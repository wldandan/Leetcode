package com.wl.array;

import java.util.Arrays;

class Solution1535 {

    public int getWinner(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        if (k > arr.length) return Arrays.stream(arr).max().getAsInt();

        int maxLeft = arr[0];
        int winRoundCount = 0;
        int[] arrWin = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            if (i > 0){
                maxLeft = Math.max(maxLeft, arr[i-1]);
            }


            if (curr > maxLeft) {
                arrWin[i]++;
                if (arrWin[i] == k) return arr[i];
            }
            else continue;

            for (int j = i+1; j < arr.length; j++) {
                if (curr < arr[j]) break;
                else if (curr > arr[j]) arrWin[i]++;
                if (arrWin[i] == k) return arr[i];
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1535().getWinner(new int[]{2,1,3,5,4,6,7},2));
        System.out.println(new Solution1535().getWinner(new int[]{1,25,35,68,70,42},2));
        System.out.println(new Solution1535().getWinner(new int[]{963,541,112,470,285,93,24,953,536,363,575,522,390,9,873,940,921,198,75},6));

        System.out.println(new Solution1535().getWinner(new int[]{3,2,1},10));
        System.out.println(new Solution1535().getWinner(new int[]{1,9,8,2,3,7,6,4,5},7));
        System.out.println(new Solution1535().getWinner(new int[]{1,11,22,33,44,55,66,77,88,99},100000000));
    }

}