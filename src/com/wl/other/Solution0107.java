package com.wl.other;

import java.util.Arrays;

class Solution0107 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] matrixNew = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixNew[j][row-i-1] = matrix[i][j];
            }
        }


        for (int i = 0; i < matrixNew.length; i++) {
            for (int j = 0; j < matrixNew[0].length; j++) {
                matrix[i][j] = matrixNew[i][j];
            }
        }

        System.out.println(Arrays.toString(matrix));
    }

    public static void main(String[] args) {
        new Solution0107().rotate(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}});
    }
}