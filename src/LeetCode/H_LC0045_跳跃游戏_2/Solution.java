package LeetCode.H_LC0045_跳跃游戏_2;

public class Solution {
    //贪心算法
    public int jump(int[] nums) {
        if(nums.length == 0)
            return 0;
        int reach = 0;
        int nextReach = nums[0];
        int step = 0;
        for(int i=0;i<=nums.length-1;i++){
            nextReach = Math.max(nextReach, nums[i]+i);
            if(nextReach >= nums.length-1)
                return (step+1);
            if(i == reach){
                step++;
                reach = nextReach;
            }
        }
        return step;
    }
}
