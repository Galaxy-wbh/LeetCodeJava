package LeetCode.E_Interview0029_顺时针打印矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int start = 0;
        while(m > start*2 && n > start*2){
            int endX = n - start - 1;
            int endY = m - start - 1;
            //从左到右
            for(int i=start;i<=endX;i++)
                res.add(matrix[start][i]);
            //从上到下
            if(start < endY)
                for(int i=start+1; i<=endY;i++)
                    res.add(matrix[i][endX]);
            //从右到左
            if(start < endX && start < endY)
                for(int i=endX-1;i>=start;i--)
                    res.add(matrix[endY][i]);
            //从下到上
            if(start < endX && start < endY-1)
                for(int i=endY-1;i>=start+1;i--)
                    res.add(matrix[i][start]);
            start++;
        }
        int[] ans = new int[m*n];
        int i = 0 ;
        for (Integer num:res){
            ans[i++] = num;
        }
        return ans;
    }

}
