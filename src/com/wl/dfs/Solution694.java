package com.wl.dfs;

import java.util.*;

class Solution694 {

    private static int[]  dx = new int[]{ 0, 0, -1, 1};
    private static int[] dy = new int[]{ 1, -1, 0, 0};


    public int numDistinctIslands(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> islands = new HashSet<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands.add(generateIsland(grid, queue, i, j));
                }
            }
        }
        return islands.size();
    }

    private String generateIsland(int[][] grid, Queue<int[]> queue, int i, int j) {
        queue.add(new int[]{i,j});
        StringBuffer Island = new StringBuffer();

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            Island.append(x-i);
            Island.append(y-j);
            grid[x][y] = 0;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (isValid(grid,newX, newY)) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return Island.toString();
    }

    private boolean isValid(int[][] grid, int newX, int newY) {
        return !(newX >= grid.length || newX < 0 || newY >= grid[0].length || newY < 0 || grid[newX][newY] == 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution694().numDistinctIslands(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
        System.out.println(new Solution694().numDistinctIslands(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));
        System.out.println(new Solution694().numDistinctIslands(new int[][]{{}}));
    }
}