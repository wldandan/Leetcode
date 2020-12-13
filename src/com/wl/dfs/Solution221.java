package com.wl.dfs;

class Solution221 {
    private int res = 0;

    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dfs(matrix, i, j, 1);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] matrix, int x, int y, int len) {
        if (x+len > matrix.length || y+len > matrix[0].length) {
            return;
        }

        if (isSquare(matrix, x, y, len)) {
            res = Math.max(res, len * len);
        } else {
            return;
        }


        dfs(matrix, x, y, len+1);
    }

    private boolean isSquare(char[][] matrix, int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (matrix[i][j] != '1') return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println(new Solution221().maximalSquare(matrix));
    }

}