package M_LC0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1,-1};
        if(len == 0)
            return res;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        //查找到了target元素
        //根据查找到的元素分别向左右线性扫描
        if(nums[left] == target){
            int leftIndex = left;
            int rightIndex = left;
            while(leftIndex >= 0 && nums[leftIndex] == target)
                leftIndex--;
            while(rightIndex < len && nums[rightIndex] == target)
                rightIndex++;
            res[0] = leftIndex + 1;
            res[1] = rightIndex - 1;
        }
        return res;
    }
}
