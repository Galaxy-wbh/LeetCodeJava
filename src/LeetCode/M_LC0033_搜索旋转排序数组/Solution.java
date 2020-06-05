package LeetCode.M_LC0033_搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return -1;
        return search(nums, 0, n-1, target);
    }

    public int search(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;
        int mid = left + (right-left)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < nums[right]){
            if(nums[mid] < target && target <= nums[right]){
                return search(nums, mid+1, right, target);
            }else{
                return search(nums, left, mid-1, target);
            }
        }else{
            if(nums[left]<= target && target < nums[mid]){
                return search(nums, left, mid-1, target);
            }else{
                return search(nums, mid+1, right, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {4,5,6,7,0,1,2};
        System.out.println(new Solution().search(test, 0));
    }
}
