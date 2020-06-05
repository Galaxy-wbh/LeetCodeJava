package LeetCode.M_LC0034_在排序数组中查找第一个和最后一个元素;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1,-1};
        if(len == 0)
            return res;
        int leftIndex = findFirstPostion(nums, target);

        //左边没有找到，直接返回-1
        if(leftIndex == -1)
            return res;
        int rightIndex = findLastPosition(nums, target);
        res[0] = leftIndex;
        res[1] = rightIndex;
        return res;
    }
    public int findFirstPostion(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){//小于的话一定不是解，排除，最后找到左边界
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target)
            return left;
        else
            return -1;
    }


    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > target){//大于的话一定不是解，排除，最后找到右边界
                right = mid - 1;
            }else{
                    left = mid;
            }
        }
        if(nums[left] == target)
            return left;
        else return -1;
    }
}
