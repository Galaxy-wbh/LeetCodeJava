package M_LC0056;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for(int[] interval:intervals){
            //第一个区间直接放入
            //或者当前区间的start大于前一个区间的end
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);

    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(new Solution().merge(a));
    }
}
