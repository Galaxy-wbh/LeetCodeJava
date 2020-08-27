package LeetCode.E_LC1299_将每个元素替换为右侧最大元素;

public class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr == null || arr.length == 0)
            return new int[0];
        if(arr.length == 1) return new int[]{-1};
        int[] res = new int[arr.length];
        int max = arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            if(i == arr.length-1)
                res[i] = -1;
            else{
                max = arr[i+1]>max?arr[i+1]:max;
                res[i] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        new Solution().replaceElements(arr);
    }
}
