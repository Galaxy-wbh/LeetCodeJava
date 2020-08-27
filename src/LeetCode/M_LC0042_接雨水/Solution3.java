package LeetCode.M_LC0042_接雨水;

public class Solution3 {
    public int trap(int[] height) {
        int n = height.length;
        int left=0,right=n-1;
        int leftMax=0,rightMax=0;
        int res = 0;
        while(left<=right){
            if(leftMax < rightMax){
                leftMax = Math.max(height[left], leftMax);
                res += Math.max(0, leftMax - height[left]);
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                res += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return res;
    }
}
