package M_LC0200;

import java.util.ArrayDeque;

public class Solution2 {
    //BFS
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ArrayDeque<int[]> queue = new ArrayDeque<>();
                if (grid[i][j] == '1' && visited[i][j] == false){
                    res++;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
                while(!queue.isEmpty()){
                    int[] point = queue.pop();
                    int x = point[0];
                    int y = point[1];
                    for(int k=0;k<4;k++){
                        int newX = x + dx[k];
                        int newY = y + dy[k];
                        if(newX<0 || newX>=m
                            || newY<0 || newY>=n
                            || grid[newX][newY] == '0'
                            || visited[newX][newY] == true){
                            continue;
                        }
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(new Solution2().numIslands(grid2));
    }
}
