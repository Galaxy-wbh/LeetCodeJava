package LeetCode.M_LC0042_接雨水;

public class Solution {
    //动态规划
    public int trap(int[] height){
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        int leftMax = height[0];
        int rightMax = height[len-1];
        for(int i=0;i<len;i++){
            if(height[i] > leftMax)
                leftMax = height[i];
            left_max[i] = leftMax;
        }
        for(int i=len-1;i>=0;i--){
            if(height[i]>rightMax)
                rightMax = height[i];
            right_max[i] = rightMax;
        }
        int res = 0;
        for(int i=0;i<len;i++){
            int minHeight = Math.min(left_max[i], right_max[i]);
            if(height[i] < minHeight){
                res += minHeight-height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Solution().trap(test);
    }
}
