package LeetCode.M_LC0201_数字范围按位与;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(0, 1));
    }
}
