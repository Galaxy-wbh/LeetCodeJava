package LeetCodeWeekContest.Week203;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        if(n == 0 || rounds == null || rounds.length == 0)
            return res;
        int[] ans = new int[n];
        ans[rounds[0]-1]++;
        for(int i=1;i<rounds.length;i++){
            if(rounds[i]-rounds[i-1] > 0){
                for(int j=rounds[i-1]+1;j<=rounds[i];j++){
                    ans[j-1]++;
                }
            }else{
                for(int j=rounds[i-1]+1;j<=n;j++)
                    ans[j-1]++;
                for(int j=1;j<=rounds[i];j++)
                    ans[j-1]++;
            }
        }
        int max = -1;
        for(int i=0;i<n;i++){
            if(ans[i]>max){
                max = ans[i];
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i] == max){
                res.add(i+1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().mostVisited(7, new int[]{1,3,5,7}));
    }
}
