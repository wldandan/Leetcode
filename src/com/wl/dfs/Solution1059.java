package com.wl.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1059 {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return false;
        boolean[] visited = new boolean[edges.length];

        Set<Integer> loopNodes = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == destination) return false;
            if (edges[i][1] == destination) {
                visited[i] = true;
            }

            if (edges[i][0] == edges[i][1]) {
                loopNodes.add(edges[i][0]);
            }

        }


        boolean res = dfs(source, destination, edges, loopNodes, visited);
        int visitedCount = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                visitedCount++;
            }
        }
        return  res && n == visitedCount;
    }

    private boolean dfs(int source, int destination, int[][] edges, Set<Integer> loopNodes, boolean[] visited) {
        if (loopNodes.contains(source)) {
            return false;
        }

        if (source == destination) {
            return true;
        }

        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) continue;

            if (edges[i][0] == source) {
                visited[i] = true;
                return dfs(edges[i][1], destination, edges, loopNodes, visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1059().leadsToDestination(3,new int[][]{{0,1},{0,2}}, 0, 2));
//        System.out.println(new Solution1059().leadsToDestination(3,new int[][]{{0,1},{1,0}}, 0, 1));
//        System.out.println(new Solution1059().leadsToDestination(3,new int[][]{{0,1},{0,3},{1,2},{2,1}}, 0, 3));
        System.out.println(new Solution1059().leadsToDestination(4,new int[][]{{0,1},{0,2},{1,3},{2,3}}, 0, 3));
//        System.out.println(new Solution1059().leadsToDestination(3,new int[][]{{0,1},{1,1},{1,2},{2,3}}, 0, 2));
//        System.out.println(new Solution1059().leadsToDestination(2,new int[][]{{0,1},{1,1}}, 0, 1));

//        System.out.println(new Solution1059().leadsToDestination(7,new int[][]{{0,1},{0,2},{1,3},{2,4},{3,5},{4,5},{2,6}}, 0, 5));
    }
}