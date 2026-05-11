/*

PriorityQueue<Integer> minHeap = new PriorityQueue<>();           // min-heap (default)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a); // max-heap
minHeap.offer(5);     // add → O(log n)
minHeap.peek();       // smallest (no removal) → O(1)
minHeap.poll();       // smallest (with removal) → O(log n)
minHeap.size();       // → O(1)


Classic Problem: Last Stone Weight (LeetCode 1046)
You have an array of stones, each with a positive weight. On each turn:

Pick the two heaviest stones, say weights x and y (x <= y).
If x == y, both are destroyed.
If x < y, the lighter is destroyed and the heavier becomes y - x.
Repeat until at most one stone remains. Return its weight (or 0 if none).

Example:

stones = [2, 7, 4, 1, 8, 1]
Turn 1: smash 8, 7 → 1 left.   stones = [2, 4, 1, 1, 1]
Turn 2: smash 4, 2 → 2 left.   stones = [2, 1, 1, 1]
Turn 3: smash 2, 1 → 1 left.   stones = [1, 1, 1]
Turn 4: smash 1, 1 → both gone. stones = [1]
Return: 1


Java Tip: Build a Heap from an Array Efficiently
Two ways to populate the heap:

Way 1 — n inserts (O(n log n)):

PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
for (int s : stones) heap.offer(s);


Way 2 — bulk construction with a stream (still O(n log n) in Java's PQ, but cleaner):


PriorityQueue<Integer> heap = new PriorityQueue<>(
    Arrays.stream(stones).boxed().collect(Collectors.toList()).stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList())
        .size(),  // initial capacity
    (a, b) -> b - a
);

Way 2 is unnecessarily fancy.

*/


// Trigger: "Repeatedly pick best item, then put something back." Insight: Use a PriorityQueue when the "best" changes dynamically.


class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->b-a);

        for(int s: stones){
            heap.offer(s);
        }


       while(heap.size()>1){
        int first=heap.poll();
        int second=heap.poll();

        if(first==second){
            continue;
        }else{
            heap.offer(Math.abs(second-first));
        }

       }

        if(heap.size()==0){
            return 0;
        }else{
            return heap.poll();
        }


    }
}


/*
LC 1167 — Min Cost to Connect Sticks (min-heap variant)

public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s : sticks) pq.offer(s);
    int cost = 0;
    while (pq.size() > 1) {
        int merged = pq.poll() + pq.poll();
        cost += merged;
        pq.offer(merged);
    }
    return cost;
}


LC 621 — Task Scheduler (heap + cooldown)

public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) freq[c - 'A']++;
    Arrays.sort(freq);
    int maxFreq = freq[25], idle = (maxFreq - 1) * n;
    for (int i = 24; i >= 0 && idle > 0; i--) idle -= Math.min(maxFreq - 1, freq[i]);
    return tasks.length + Math.max(0, idle);
}

*/





