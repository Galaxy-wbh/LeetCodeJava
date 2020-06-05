package LeetCode.M_Interview08_11_硬币;

public class Solution {
    //二维dp,完全背包问题
    public int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[][] dp = new int[4][n+1];

        //只有1分的硬币，所有金额的组成只有1种
        for(int i=0;i<=n;i++)
            dp[0][i] = 1;
        //金额为0，所有的硬币都用上也只有1种办法(就是无法组成)
        for(int i=0;i<4;i++)
            dp[i][0] = 1;

        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j >= coins[i])
                    dp[i][j] = (dp[i-1][j] + dp[i][j-coins[i]])%1000000007;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[3][n];
    }

}
