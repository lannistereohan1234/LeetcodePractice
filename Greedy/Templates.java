// The Three Universal Templates to Memorize Cold

// If you forget everything else, remember these three skeletons — 80% of greedy problems are one of them.


//  Template 1 — Sort + Single Linear Scan
Arrays.sort(arr, comparator);
int result = 0, marker = initial;
for (item : arr) {
    if (condition(item, marker)) {
        result++;
        marker = update(item);
    }
}
return result;


//Template 2 — Linear Scan with Running State
int state = initial;
for (int i = 0; i < n; i++) {
    if (failCondition(i, state)) return failValue;
    state = update(state, i);
}
return state;


//Template 3 — Heap-Driven Selection

PriorityQueue<T> pq = new PriorityQueue<>(comparator);
for (item : input) pq.offer(item);
while (condition(pq)) {
    T best = pq.poll();
    T result = process(best);
    if (shouldReoffer(result)) pq.offer(result);
}
return pq.peek();
