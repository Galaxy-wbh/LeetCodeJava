package LeetCode.M_LC0739_每日温度;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    //单调栈
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && T[stack.peekLast()]<T[i]){
                int popNum = stack.pollLast();
                res[popNum] = i-popNum;
            }
            stack.offerLast(i);
        }
        while(!stack.isEmpty()){
            int popNum = stack.pollLast();
            res[popNum] = 0;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] t = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(new Solution().dailyTemperatures(t));
    }
}
