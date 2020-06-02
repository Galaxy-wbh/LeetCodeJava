package H_LC0887;

public class Solution {
    /*
    中间查找楼层用二分法，复杂度为O(KNlogN)
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
                //减治二分法搜索最小楼层
                int left = 1;
                int right = j;
                while(left < right){
                    int mid = left + (right - left + 1)/2;
                    int breakCount = dp[i-1][mid-1];//递增
                    int notBreakCount = dp[i][j-mid];//递减
                    if(breakCount > notBreakCount){
                        right = mid - 1;
                    }else{
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[i-1][left-1], dp[i][j-left])+1;
            }
        }
        return dp[K][N];
    }
}
