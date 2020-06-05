package LeetCode.E_LC0035_搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return 0;

        if(nums[len-1] < target)
            return len;
        //排除法(减治)二分
        int left = 0, right = len-1;
        //left严格小于right，出循环后left和right相等
        while(left < right){
            //不这么写是因为left+right可能会溢出
            //int mid = (left+right)/2
            int mid = left + (right - left)/2;
            //mid元素严格小于目标元素
            //排除带mid的那部分
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
