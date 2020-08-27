package LeetCode.M_LC0491_递增子序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer>  list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    public void dfs(int cur, int last, int[] nums){
        if(cur == nums.length){
            if(list.size() >= 2){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[cur] >= last){
            list.add(nums[cur]);
            dfs(cur+1, nums[cur], nums);
            list.remove(list.size()-1);
        }
        if(nums[cur] != last){
            dfs(cur+1, last, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7,7}));
    }

}
