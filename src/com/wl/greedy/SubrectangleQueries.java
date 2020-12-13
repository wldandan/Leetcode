package com.wl.greedy;

class SubrectangleQueries {

    private int[][] rect;
    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2 ; i++) {
            for (int j = col1; j <= col2; j++) {
                rect[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        System.out.println(rect[row][col]);
        return rect[row][col];
    }

    public static void main(String[] args) {
        testCase2();
    }

    private static void testCase1() {
        SubrectangleQueries sub = new SubrectangleQueries(new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}});
        sub.getValue(0,2);

        sub.updateSubrectangle(0,0,3,2,5);

        sub.getValue(0,2);
        sub.getValue(3,1);
        sub.updateSubrectangle(3,0,3,2,10);

        sub.getValue(3,1);
        sub.getValue(0,2);
    }

    private static void testCase2() {
        SubrectangleQueries sub = new SubrectangleQueries(new int[][]{{1,1,1},{2,2,2},{3,3,3}});
        sub.getValue(0,0);

        sub.updateSubrectangle(0,0,2,2,100);

        sub.getValue(0,0);
        sub.getValue(2,2);
        sub.updateSubrectangle(1,1,2,2,20);

        sub.getValue(2,2);
    }
}



/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */