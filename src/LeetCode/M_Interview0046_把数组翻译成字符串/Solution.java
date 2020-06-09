package LeetCode.M_Interview0046_把数组翻译成字符串;

public class Solution {
    public int translateNum(int num) {
        String numString = num+"";
        int[] dp = new int[numString.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<numString.length()+1;i++){
            String n = numString.substring(i-2, i);
            int numN = Integer.valueOf(n);
            if(numN>=10 && numN<=25){
                dp[i] = dp[i-2] + dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[numString.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(26));
    }
}
