package LeetCode.M_LC0055_跳跃游戏;

public class Solution {
    //贪心算法，比较当前位置能达到的距离和现在已经走过数组的数据所能达到的最大距离
    //如果所能达到距离超过数组长度，那么就可以到达
    public boolean canJump(int[] nums) {
        int start = 0, end = 0;
        while(start <= end && end < nums.length-1){
            end = Math.max(nums[start] + start, end);
            start++;
        }
        return end >= nums.length-1;
    }
}
