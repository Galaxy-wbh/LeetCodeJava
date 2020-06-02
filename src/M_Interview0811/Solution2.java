package M_Interview0811;

public class Solution2 {
    //1纬dp，优化空间
    public int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i] = 1;
        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j >= coins[i])
                    dp[j] = (dp[j] + dp[j-coins[i]])%1000000007;
            }
        }
        return dp[n];
    }
}
