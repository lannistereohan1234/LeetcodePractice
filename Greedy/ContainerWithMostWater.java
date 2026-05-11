
//Trigger: "Two endpoints, max/min something between them." Insight: Move the pointer with the worse value — the alternative is provably useless.

class Solution {
    public int maxArea(int[] height) {
        int n=height.length;

        int left=0;
        int right=n-1;

        int area=Integer.MIN_VALUE;

        while(left<right){
             area=Math.max(area, Math.abs(right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right]){     // moving smaller side helps to get bigger area
                left++;
            }else{
                right--;
            }
        }

        return area;

    }
}


/*

LC 42 — Trapping Rain Water (two-pointer greedy variant)

public int trap(int[] height) {
    int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            leftMax = Math.max(leftMax, height[l]);
            water += leftMax - height[l++];
        } else {
            rightMax = Math.max(rightMax, height[r]);
            water += rightMax - height[r--];
        }
    }
    return water;
}

*/
