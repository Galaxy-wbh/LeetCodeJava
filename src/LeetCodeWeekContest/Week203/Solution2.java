package LeetCodeWeekContest.Week203;

import LeetCode.H_LC0679_24点游戏.Solution;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

    public int maxCoins(int[] piles) {
        if(piles == null || piles.length % 3 != 0)
            return 0;
        Integer newPiles[] = new Integer[piles.length];
        for(int i=0;i<piles.length;i++){
            newPiles[i]= new Integer(piles[i]);
        }
        Arrays.sort(newPiles,Collections.reverseOrder());
        int left = 1, right = piles.length-1;
        int res = 0;
        while(left < right){
            res += newPiles[left];
            left+=2;
            right--;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().maxCoins(new int[]{2,4,5}));
    }
}
