
//Trigger: "Reconstruct / order with two attributes." Insight: Sort by primary key (the one whose order won't be disturbed by future ops); use secondary key for tiebreaking.



class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // very very tricky

        // primary task is to make the queue logical where first is height, second is how many people should
        // stand in front of first height person, so that can justify the second value
        // a person of the smallest height can see persons in front of them with greater height


        
        // Sort rule:

        // Primary: height descending (tallest first)
        // Tiebreaker: k ascending (smaller k first among same heights)


        
        // 1. Sort: Height descending, then k-value ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // Tiebreaker: k ascending
            }
            return b[0] - a[0];     // Height descending
        });

        // 2. Insert: Use a list to handle index-based positioning
        // LinkedList is often preferred for many middle insertions
        List<int[]> resultList = new LinkedList<>();
        for (int[] person : people) {
            resultList.add(person[1], person);
        }

        // 3. Convert back to a 2D array
        return resultList.toArray(new int[people.length][2]);
    

    }
}



/*

LC 1029 — Two City Scheduling (sort by refund / cost difference)

public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
    int total = 0, n = costs.length / 2;
    for (int i = 0; i < costs.length; i++) total += (i < n) ? costs[i][0] : costs[i][1];
    return total;
}

*/


