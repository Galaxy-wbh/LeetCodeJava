package E_LC0704;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return -1;
        int left = 0;
        int right = len-1;
        //减治二分
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        //后处理，二分最后出来的元素是否存在
        if(nums[left] != target)
            return -1;
        return left;
    }
}
