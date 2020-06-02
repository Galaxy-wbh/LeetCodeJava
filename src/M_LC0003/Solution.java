package M_LC0003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int rk = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while(rk+1<n && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            res = Math.max(res, rk-i+1);
        }
        return res;
    }
}
