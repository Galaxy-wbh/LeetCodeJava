package LeetCode.H_LC0128_最长连续序列;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num:nums){
            if(map.get(num) == null){
                //计算左右相邻数字的区间长度
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int cur = left + right + 1;
                if(max < cur)
                    max = cur;
                map.put(num, cur);//放入哈希表中
                //更新左右区间端点的区间长度
                map.put(num-left, cur);
                map.put(num+right, cur);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
