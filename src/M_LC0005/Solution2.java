package M_LC0005;

public class Solution2 {
    //中心扩散
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2)
            return s;
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for(int i=0;i<len-1;i++){
            int oddLen = extendPalindrome(charArray, i,i);
            int evenLen = extendPalindrome(charArray, i, i+1);

            int currentMax = Math.max(oddLen, evenLen);
            if(currentMax > maxLen){
                maxLen = currentMax;
                begin = i - (maxLen-1)/2;
            }
        }

        return s.substring(begin, begin+maxLen);
    }
    private int extendPalindrome(char[] charArray, int left, int right){
        while(left >=0 && right < charArray.length && charArray[left] == charArray[right]){
            left--;
            right++;
        }
        return right-left-1;
    }

}
