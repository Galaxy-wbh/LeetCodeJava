package LeetCode.M_LC0221_最大正方形;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        int max = 0;
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max*max;
    }



    public static void main(String[] args) {
        char[][] test = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        //System.out.println(new Solution().maximalSquare(test));
    }
}
