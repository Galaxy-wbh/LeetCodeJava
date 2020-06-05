package LeetCode.M_LC0200_岛屿数量;

import java.util.Arrays;
public class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    int m;
    int n;
    //DFS
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res  = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        //初始化访问数组
        for(int i=0;i<m;i++)
            Arrays.fill(visited[i], false);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    res++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] visited, char[][] grid, int i, int j){
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int newX = i + dx[k];
            int newY = j + dy[k];
            if(newX<0 || newX>=m
                    || newY<0 || newY>=n
                    || grid[newX][newY] == '0'
                    || visited[newX][newY] == true){
                continue;
            }else{
                dfs(visited, grid, newX, newY);
            }
        }
    }
}
