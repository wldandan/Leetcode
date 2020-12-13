package com.wl.other;

class Solution11 {
    public int maxArea(int[] height) {
        int area = 0;
        if (height.length == 0) return area;

        int length = 0;

        for (int i = 0; i < height.length; i++) {
            length = height[i];
            for (int j = i+1; j < height.length; j++) {
                area = Math.max(area, (j-i)* (Math.min(length, height[j])));
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}