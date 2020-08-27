package LeetCode.M_LC0042_接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    //单调栈
    public int trap(int[] height){
        if(height == null || height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int res = 0;
        while(i < height.length){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int boundHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                res += boundHeight*distance;
            }
            stack.push(i++);
        }
        return res;
    }
}
