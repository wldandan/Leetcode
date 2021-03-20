package com.wl.array;

import java.util.Arrays;

class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            int[] reversedOrderArray = reverseOrder(A[i]);
            res[i] = reverseValue(reversedOrderArray);
        }
        return res;
    }

    private int[] reverseValue(int[] array) {
        int length = array.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (array[i] == 0) {
                res[i] = 1;
            }
            else res[i] = 0;
        }
        return res;
    }

    private int[] reverseOrder(int[] array) {
        int length = array.length;
        int i = 0;
        int j = length-1;
        while(i < j) {
            swap(array,i,j);
            i++;
            j--;
        }
        return array;
    }

    private void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase2() {
        int[][] res = new Solution832().flipAndInvertImage(new int[][]{{1,1,0,0}, {1,0,0,1}, {0,1,1,1},{1,0,1,0}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    private static void testCase1() {
        int[][] res = new Solution832().flipAndInvertImage(new int[][]{{1,1,0}, {1,0,1}, {0,0,0}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}