package com.wl.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution200 {
    public int numIslands(char[][] grid) {

        if (grid == null && grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    grid[i][j] = '0';
                    res++;

                    queue.offer(grid[i][j]);
                    while(!queue.isEmpty()){
                        Character c = queue.poll();

                        if (isValid(grid, i+1, j)) {
                            queue.offer(grid[i+1][j]);
                            grid[i+1][j] = '0';
                        }

                        if (isValid(grid, i-1, j)) {
                            queue.offer(grid[i-1][j]);
                            grid[i-1][j] = '0';

                        }
                        if (isValid(grid, i, j+1))  {
                            queue.offer(grid[i][j+1]);
                            grid[i][j+1] = '0';
                        }
                        if (isValid(grid, i, j-1)) {
                            queue.offer(grid[i][j-1]);
                            grid[i][j-1] = '0';
                        }

                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return false;
        if ((grid[i][j]) == '0') return false;
        return true;
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