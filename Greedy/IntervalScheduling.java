/*
The Setup
You're given a list of intervals (e.g., meetings, jobs, activities), each with a [start, end) time. The questions usually look like:

"Maximum number of non-overlapping intervals you can pick?"
"Minimum number of intervals to remove so the rest don't overlap?"
"Minimum rooms / arrows / resources needed?"
"Can you attend all meetings?"
These all reduce to one core question:

"Given overlapping intervals, what's the smartest way to pick / merge / remove them?"

The Big Question (no code yet — just intuition)
Imagine you have these meetings on your calendar (each a [start, end) pair):

 A: [1, 4)
 B: [2, 6)
 C: [5, 7)
 D: [3, 8)
 E: [7, 9)
You can only attend non-overlapping meetings. Maximize the count.

Three plausible greedy strategies — which would you pick and why?

Earliest start time first (sort by start ascending)
Shortest duration first (sort by end - start ascending)
Earliest end time first (sort by end ascending)


*/


// Similar leetcode problems:

// 435 -- Non-overlapping Intervals -- End time
//452 -- Min Arrows to Burst Balloons -- End coordinate
//646 -- Maximum Length of Pair Chain -- Second element
//1326 -- Min Taps to Water Garden -- (variant)


//Trigger: "Non-overlapping / max activities / min removals / arrows." Insight: Sort by end ascending. Pick when start >= prevEnd.

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int n = intervals.length;
        // Sort by end time to maximize the number of non-overlapping intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 1; // count of non-overlapping intervals kept

        for (int i = 1; i < n; i++) {
            // If current start is >= previous end, there is no overlap
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }

        // Total intervals minus the ones we kept = intervals to remove
        return n - count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals sol = new NonOverlappingIntervals();

        // Test Case 1: Standard overlap
        int[][] test1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Test 1 Result: " + sol.eraseOverlapIntervals(test1)); // Expected: 1

        // Test Case 2: All overlapping
        int[][] test2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Test 2 Result: " + sol.eraseOverlapIntervals(test2)); // Expected: 2

        // Test Case 3: No overlaps
        int[][] test3 = {{1, 2}, {2, 3}};
        System.out.println("Test 3 Result: " + sol.eraseOverlapIntervals(test3)); // Expected: 0
    }
}



/*

LC 452 — Min Arrows to Burst Balloons (similar — note > vs >=)
The difference: LC 435 treats touching as non-overlap (>=). LC 452 treats touching as poppable by same arrow (> for new arrow). Memorize this distinction.


public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int arrows = 1, end = points[0][1];
    for (int i = 1; i < points.length; i++) {
        if (points[i][0] > end) { arrows++; end = points[i][1]; }
    }
    return arrows;
}


*/









