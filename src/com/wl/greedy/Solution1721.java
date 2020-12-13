package com.wl.greedy;

class Solution1721 {

    public int trap(int[] height) {
        if(height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;

        while(left < right){
            if(leftmax < rightmax){
                res += leftmax - height[left++];
                leftmax = Math.max(height[left], leftmax);
            }else{
                res += rightmax - height[right--];
                rightmax = Math.max(height[right], rightmax);
            }
        }
        return res;
    }

    public int trap2(int[] height) {

        if (height == null || height.length == 0 ) return 0;

        int res = 0;

        for (int i = 1; i < height.length-1; i++) {

            int left = height[0];
            int right = height[height.length-1];


            for (int j = i-1; j >0 ; j--) {
                left = Math.max(left, height[j]);
            }
            for (int j = i+1; j < height.length ; j++) {
                right = Math.max(right, height[j]);
            }

            if (height[i] < left && height[i] < right){
                res += Math.min(left, right) - height[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1721().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}