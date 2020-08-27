package LeetCode.M_LC0529_扫雷游戏;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dx = {0, 0, 1, -1, 1,  1, -1, -1};
    int[] dy = {1, -1, 0, 0, 1, -1,  1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            int cnt = 0;
            for(int k=0;k<8;k++){
                int newX = i + dx[k];
                int newY = j + dy[k];
                if(newX < 0 || newX >= m || newY<0 || newY >= n){
                    continue;
                }
                if(board[newX][newY] == 'M') cnt++;
            }

            if(cnt > 0){
                board[i][j] = (char)(cnt + '0');
            }else{
                board[i][j] = 'B';
                for(int k=0;k<8;k++){
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if(newX < 0 || newX >= m || newY<0 || newY >= n
                    || board[newX][newY] != 'E' || visited[newX][newY]){
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] chars = {{'E','E','E','E','E'},
                        {'E','E','M','E','E'},
                        {'E','E','E','E','E'},
                        {'E','E','E','E','E'}};
        System.out.println(new Solution().updateBoard(chars, new int[]{3,0}));

    }
}

