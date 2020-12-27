package com.wl.dfs;

class SolutionOffer12 {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word.toCharArray(), i, j, 0, visited)) return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, char[] words, int x, int y, int index, boolean[][] visited) {
        if (x < 0 || x >= board.length || y<0 || y >=board[0].length || visited[x][y]) return false;

        if (board[x][y] != words[index]) return false;

        if (index == words.length-1) return true;

        visited[x][y] = true;

        boolean res = false;
        for (int i = 0; i < dirs.length; i++) {

            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];

            if (dfs(board, words, nx, ny, index+1, visited)) return true;
        }

        visited[x][y] = false;
        return res;
    }




    public static void main(String[] args) {
        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'B','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(new SolutionOffer12().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(new SolutionOffer12().exist(new char[][]{{'a','b'},{'c','d'}}, "abcd"));
    }
}