package com.wl.dfs;

import java.util.HashSet;
import java.util.Set;

class Solution694 {

    /*
    * 1)使用StringBuffer,存储岛屿区域内节点与起始点的差值,从而使用Set判断去重
    * 2)DFS,将传入的节点作验证,验证有效的节点设置为0,保存差值
    * */

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

    private void generateIsland(int[][] grid, StringBuffer island, int i, int j, int startX, int startY) {
        if (!isValid(grid, i, j)) return;

        grid[i][j] = 0; //表示当前已处理

        island.append(i - startX); //记录相对坐标
        island.append(j - startY); //记录相对坐标

        generateIsland(grid, island, i-1, j, startX, startY); //上
        generateIsland(grid, island, i+1, j, startX, startY); //下
        generateIsland(grid, island, i, j-1, startX, startY); //左
        generateIsland(grid, island, i, j+1, startX, startY); //右

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