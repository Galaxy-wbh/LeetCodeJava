package M_LC0974;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res=0,sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            int modules = (sum%K+K)%K;
            int same = map.getOrDefault((sum%K+K)%K,0);
            res+=same;
            map.put(modules, same+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {4,5,0,-2,-3,1};
        System.out.println(new Solution().subarraysDivByK(test, 5));
    }
}
