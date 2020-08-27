package LeetCode.M_LC0416_分割等和子集;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i=0;i<len;i++)
            sum += nums[i];
        if(sum % 2 != 0)
            return false;
        int target = sum/2;
        boolean[][] dp = new boolean[len][target+1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<=target;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[len-1][target];
    }

    public static void main(String[] args) {
        new Solution().canPartition(new int[]{1, 5, 11, 5});
    }
}
