package LeetCode.M_LC0238_除自身以外数组的乘积;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        res[0] = 1;
        int right = 1;
        for(int i=1;i<nums.length;i++){
            res[i] *= res[i-1]*nums[i-1];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().productExceptSelf(new int[]{9,0,-2}).toString());
    }
}
