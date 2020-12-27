package com.wl.bfs;

import java.util.LinkedList;
import java.util.Queue;

class SolutionOffer12 {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        boolean res = false;
        if (word == null || word.length() == 0) return res;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (bfs(board, word, i, j, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int x, int y, boolean[][] visited) {
        StringBuffer sBuf = new StringBuffer();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int index = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 0 && index < word.length() ) sBuf.append(String.valueOf(word.charAt(index)));
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir: dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if (nx>=0 && nx < board.length && ny >=0 && ny<board[0].length && !visited[nx][ny]) {
                        if (index < word.length()-1 && board[nx][ny] == word.charAt(index+1) ) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            index++;
        }
        return sBuf.toString().equals(word);
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
//        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'B','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
//        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
//        System.out.println(new SolutionOffer12().exist(new char[][]{{'a','b'},{'c','d'}}, "abcd"));
    }
}