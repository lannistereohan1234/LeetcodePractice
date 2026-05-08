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

