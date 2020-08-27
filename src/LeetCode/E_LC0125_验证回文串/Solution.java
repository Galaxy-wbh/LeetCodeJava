package LeetCode.E_LC0125_验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        if(s == null || s.length()==0)
            return true;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(valid(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        s = sb.toString();
        int left=0,right=s.length()-1;
        while (left<=right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean valid(char c){
        return (c>='a'&&c<='z') || (c>='0' && c<='9');
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(s));
    }
}
