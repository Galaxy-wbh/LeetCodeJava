package LeetCode.M_LC1300_转变数组后最接近目标值的数组和;

import java.util.Arrays;

public class Solution {
    //枚举+二分
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        //前缀和
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1]+arr[i-1];
        }
        int r = arr[n-1];
        int ans = 0, diff = target;
        for(int i=1;i<=r;i++){
            int index = Arrays.binarySearch(arr, i);
            if(index < 0){
                index = -index-1;
            }
            int cur = prefix[index] + (n-index)*i;
            if(Math.abs(cur - target) < diff){
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = new int[]{2,3,5};
        System.out.println(new Solution().findBestValue(a, 11));
    }
}
