package LeetCode.M_LC0005_最长回文子串;

public class Solution3 {
    //动态规划
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2)
            return s;
        int maxLen = 1;
        int begin = 0;

        //dp[i][j]表示s[i...j]是否为回文串
        Boolean dp[][] = new Boolean[len][len];
        for(int i=0;i<len;i++)
            dp[i][i] = true;

        char[] charArray = s.toCharArray();
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i < 3){//回文串为"aa"或者"a"类型
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

}
