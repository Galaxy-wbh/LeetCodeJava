package LeetCode.M_LC0003_无重复的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0,j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j))+1,i);
            }
            map.put(s.charAt(j),j);
            max = Math.max(max, j-i+1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "bbtablud";
        System.out.println(new Solution().lengthOfLongestSubstring(s));

    }
}
