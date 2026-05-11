class Solution {

    // "If you fail at station i, everything before i is a dead end; if the total gas is enough, the next station is the start."
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0; // Fuel left to reach the next station
        int total = 0;   // Overall fuel balance for the entire trip
        int start = 0;   // The candidate starting station

        int n = gas.length;

        for (int i = 0; i < n; i++) {
            // Track both the current tank and the global feasibility
            current += gas[i] - cost[i];
            total += gas[i] - cost[i];

            // IF YOU FAIL HERE: You can't start at 'start' OR anywhere in between
            if (current < 0) {
                current = 0;   // Reset the tank
                start = i + 1; // Move the starting line past the failure point
            }
        }

        // IF THE MATH ADDS UP: The total gas must cover the total cost to win
        return (total >= 0) ? start : -1;
    }
}
