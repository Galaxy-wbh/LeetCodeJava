package LeetCode.M_LC0560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    //hashmap优化
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)){
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
