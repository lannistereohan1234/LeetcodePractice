import java.util.Arrays;

// similar problems:
// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
// https://leetcode.com/problems/maximum-ice-cream-bars/description/
// https://leetcode.com/problems/boats-to-save-people/description/
// https://leetcode.com/problems/bag-of-tokens/description/
// https://leetcode.com/problems/candy/description/


//Trigger: "Match items from two lists / fit X to Y." Insight: Sort both, walk with two pointers.

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort both arrays to use the greedy approach
        Arrays.sort(g);
        Arrays.sort(s);

        int childPointer = 0;
        int cookiePointer = 0;

        // Step 2: Iterate through both arrays
        while (childPointer < g.length && cookiePointer < s.length) {
            // If the current cookie can satisfy the current child
            if (s[cookiePointer] >= g[childPointer]) {
                childPointer++; // Move to the next child
            }
            // Move to the next cookie regardless of whether it was used
            cookiePointer++;
        }

        // The index of childPointer represents the number of satisfied children
        return childPointer;
    }

    public static void main(String[] args) {
        AssignCookies sol = new AssignCookies();

        // Example 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Result 1: " + sol.findContentChildren(g1, s1)); // Output: 1

        // Example 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Result 2: " + sol.findContentChildren(g2, s2)); // Output: 2
    }
}



// LC 1710 — Maximum Units on a Truck (similar)
/*
public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
    int units = 0;
    for (int[] b : boxTypes) {
        int take = Math.min(truckSize, b[0]);
        units += take * b[1];
        truckSize -= take;
        if (truckSize == 0) break;
    }
    return units;
}
*/


