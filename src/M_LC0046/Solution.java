package M_LC0046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //回溯法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums));
    }
}
