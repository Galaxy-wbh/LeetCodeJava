package M_LC0005;

public class Solution1 {
    //暴力解法
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2)
            return s;
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(j-i+1 > maxLen && validPalindrome(charArray, i, j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    private boolean validPalindrome(char[] charArray, int left, int right){
        while(left < right){
            if(charArray[left] == charArray[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
