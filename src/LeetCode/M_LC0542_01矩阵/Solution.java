package LeetCode.M_LC0542_01矩阵;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null) return null;
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        //0元素入队
        for(int i=0;i<m;i++) {
            Arrays.fill(res[i], 0);
            Arrays.fill(visited[i], false);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    queue.offer(i*n+j);
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        //BFS
        while(!queue.isEmpty()){
            int index = queue.poll();
            int x = index/n;
            int y = index%n;
            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(newX<0 || newY<0 || newX>=m || newY>=n
                || visited[newX][newY] == true){
                    continue;
                }
                res[newX][newY] += res[x][y] + 1;
                visited[newX][newY] = true;
                queue.offer(newX*n+newY);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
