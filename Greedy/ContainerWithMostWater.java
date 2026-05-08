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
