package com.wl.backtrace;

class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if ( (i== 0 || flowerbed[i-1] == 0) &&
                 (flowerbed[i] == 0) &&
                 ( i== flowerbed.length - 1 || flowerbed[i+1] == 0 )) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) return true;
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution605().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
//        System.out.println(new Solution605().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
//        System.out.println(new Solution605().canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(new Solution605().canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
    }
}