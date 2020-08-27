package LeetCode.M_LC0079_单词搜索;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;
    int m;
    int n;
    //DFS
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board, i, j, 0, word))
                    return true;

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, String word){

        if(index == word.length()-1)
            return word.charAt(index) == board[i][j];
        if(word.charAt(index) == board[i][j]){
            visited[i][j] = true;
            for(int k=0;k<4;k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    if (dfs(board, newX, newY, index + 1, word)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        //System.out.println(new Solution().exist(board, word));
        LinkedList<Integer> queue = new LinkedList<>();

    }
}
