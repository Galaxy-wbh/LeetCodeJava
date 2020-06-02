package M_LC0011;

public class Solution {
    //双指针
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = 0;
        while(start < end){
            max = Math.max(max, (end - start) * Math.min(height[end], height[start]));
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        return max;
    }
}
