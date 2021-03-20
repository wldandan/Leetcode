package com.wl.hash;

import java.util.HashSet;
import java.util.Set;

class Solution694 {
    private static int[] dx = new int[]{ 0, 0, -1, 1};
    private static int[] dy = new int[]{ 1, -1, 0, 0};

    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuffer island = new StringBuffer();
                    generateIsland(grid, island, i, j, i, j);
                    islands.add(island.toString());
                }
            }
        }
        return islands.size();
    }

    private void generateIsland(int[][] grid, StringBuffer island, int i, int j,
                                int startX, int startY) {
        if (!isValid(grid, i, j)) return;
        grid[i][j] = 0;
        island.append(i - startX);
        island.append(j - startY);
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            generateIsland(grid, island, newX, newY, startX, startY);
        }
    }

    private boolean isValid(int[][] grid, int newX, int newY) {
        return !(newX >= grid.length || newX < 0 || newY >= grid[0].length || newY < 0 || grid[newX][newY] == 0);
    }
}