package E_LC0680;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    //递归
    private int count = 1;
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)
            return false;
        return validPalindrome(s, 0, s.length()-1);
    }
    public boolean validPalindrome(String s, int start, int end){
        if(s.length() == 1)
            return true;
        if(s.charAt(start) == s.charAt(end)){
            if(start-end == 1 || start == end)
                return true;
            else
                return validPalindrome(s, start+1, end-1);
        }else{
            if(count == 1){
                count--;
                return validPalindrome(s,start+1, end) || validPalindrome(s, start, end-1);
            }else{
                return false;
            }

        }
    }
    public String PrintMinNumber(int [] numbers) {
        String s = "";
        ArrayList<Integer> data = new ArrayList<>();
        for(int i=0;i<numbers.length;i++)
            data.add(numbers[i]);
        Collections.sort(data, (o1, o2)->(o1+s+o2).compareTo(o2+s+o1));
        StringBuilder sb = new StringBuilder();
        for(Integer i:data){
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(new Solution().PrintMinNumber(a));
    }
}