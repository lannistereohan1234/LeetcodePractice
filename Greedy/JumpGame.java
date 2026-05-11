import java.util.Arrays;

// Trigger: "Can you reach / minimum jumps / furthest position." Insight: Track maxReach; fail if i > maxReach

public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our max reach, we are stuck
            if (i > maxReach) {
                return false;
            }
            // Update the furthest index we can reach so far
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return maxReach >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Reachable
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1 " + Arrays.toString(nums1) + ": " + sol.canJump(nums1));

        // Test Case 2: Not Reachable (Stuck at the 0)
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test Case 2 " + Arrays.toString(nums2) + ": " + sol.canJump(nums2));
    }
}


/*

LC 45 — Jump Game II (similar — count jumps)

public int jump(int[] nums) {
    int jumps = 0, currentEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currentEnd) { jumps++; currentEnd = farthest; }
    }
    return jumps;
}


*/
