package com.wl.dfs;

class Solution200 {
    public int numIslands(char[][] grid) {

        if (grid == null && grid.length == 0) return 0;


        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i >= grid.length || j>=grid[0].length || i<0 || j<0) return;
        if (grid[i][j] == '0') return;

        if (grid[i][j] == '1') grid[i][j] = '0';

        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j+1);
        helper(grid, i, j-1);

    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new Solution200().numIslands(input));



        input = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new Solution200().numIslands(input));
    }

}