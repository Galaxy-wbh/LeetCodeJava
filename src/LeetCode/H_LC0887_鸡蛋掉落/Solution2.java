package LeetCode.H_LC0887_鸡蛋掉落;

public class Solution2 {
    /*
        O(KN^2)解法，超时
     */
    public int superEggDrop(int K, int N) {//K个蛋，N层楼
        int[][] dp = new int[K+1][N+1];

        //0层楼，多少鸡蛋都测不出
        for(int i=1;i<K+1;i++)
            dp[i][0] = 0;

        //只有1层楼的时候，0个鸡蛋扔0次，否则都是扔1次鸡蛋
        dp[0][1] = 0;
        for(int i=1;i<K+1;i++)
            dp[i][1] = 1;

        //只有1个蛋，0个鸡蛋扔0次，否则线性扫描
        for(int i=1;i<N+1;i++){
            dp[1][i] = i;
            dp[0][i] = 0;
        }
        for(int i=2;i<K+1;i++){
            for(int j=2;j<N+1;j++){
                for(int k=1;k<j+1;k++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k])+1);
            }
        }
        return dp[K][N];
    }
}
