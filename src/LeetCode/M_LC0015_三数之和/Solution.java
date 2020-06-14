package LeetCode.M_LC0015_三数之和;

import java.util.*;

public class Solution {
    //双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum < 0) left++;
                else if(sum > 0) right--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new Solution().threeSum(nums);
        System.out.println(res);
    }
}
