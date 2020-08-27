package LeetCode.M_LC1014_最佳观光组合;

public class Solution {
    /**
     * A[i]+i+A[j]-j
     * 其中A[j]-j是固定的，只需要维护mx=A[i]+i为最大即可其中i=[0..j-1]
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int mx = A[0]+0;
        int res = 0;
        for(int j=1;j<A.length;j++){
            res = mx + A[j]-j > res?mx+A[j]-j:res;
            mx = A[j]+j>mx?A[j]+j:mx;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
    }
}
