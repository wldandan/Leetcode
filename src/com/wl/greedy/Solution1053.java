package com.wl.greedy;

import java.util.Arrays;

class Solution1053 {
    public int[] prevPermOpt1(int[] A) {
        int rightMax = Integer.MIN_VALUE;
        int index = -1;
        for (int i = A.length-1; i >0; i--) {
            //找到倒序的位置i,准备进行交换
            if (A[i-1] > A[i]){

                //循环判断i后面,最大的数
                for (int j = i; j < A.length; j++) {
                    if (A[j] > rightMax && A[j]< A[i-1]){
                        rightMax = A[j];
                        index = j;
                    }
                }

                //进行交换
                int tmp = A[i-1];
                A[i-1] = A[index];
                A[index] = tmp;
                break;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1053().prevPermOpt1(new int[]{3,2,1})));
        System.out.println(Arrays.toString(new Solution1053().prevPermOpt1(new int[]{1,1,5})));
        System.out.println(Arrays.toString(new Solution1053().prevPermOpt1(new int[]{3,1,1,3})));
        System.out.println(Arrays.toString(new Solution1053().prevPermOpt1(new int[]{1,9,4,5,6})));

    }
}