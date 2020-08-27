package LeetCode.M_LC0054_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up=0,down=m-1,left=0,right=n-1;
        int count = 1;
        while(count<=m*n){
            for(int i=left;i<=right;i++){
                res.add(matrix[up][i]);
                count++;
            }
            up++;
            for(int i=up;i<=down;i++){
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for(int i=right;i>=left;i--){
                res.add(matrix[down][i]);
                count++;
            }
            down--;
            for(int i=down;i>=up;i--){
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new Solution().spiralOrder(nums);
        StringBuilder sb = new StringBuilder();

    }
}
