package NewCoderContest.Contest20200711;

import java.lang.reflect.Array;
import java.util.*;

public class Solution2 {
    public int getMaxLength (int n, int[] num) {
        if(num == null || n < 3)
            return 0;
        int max = 0;
        for(int i=1;i<n-1;i++){
            if(num[i] > num[i-1] && num[i]>num[i+1]){
                int left = i-1;
                int right = i+1;
                while(left>0 && num[left]> num[left-1]){
                    left--;
                }
                while(right < n-1 && num[right+1]<num[right]){
                    right++;
                }
                if(right-left+1 > max){
                    max = right-left+1;
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(new Solution2().getMaxLength(5, new int[]{1,5,3,3,1}));
        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove( i-1);
        }
        System.out.println(map.size());
    }
}
