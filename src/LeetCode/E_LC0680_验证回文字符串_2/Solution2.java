package LeetCode.E_LC0680_验证回文字符串_2;

public class Solution2 {
    public boolean validPalindrome(String s) {
        int i=0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return isValidPalindrome(s, i+1, j) || isValidPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValidPalindrome(String s, int i, int j){
        for (int k=i;k<=i+(j-i)/2;k++){
            if(s.charAt(k) != s.charAt(j-k+i))
                return false;
        }
        return true;
    }
}
