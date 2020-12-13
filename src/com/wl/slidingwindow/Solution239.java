package com.wl.slidingwindow;

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int right=0, left=0;
        int current=0;
        int[] res=new int[nums.length-k+1];

        while (left <= nums.length-k){
            right = left + k -1;

            for (int i = left; i <= right; i++) {
                current = Math.max(current, nums[i]);
            }
            res[left] = current;
            current = Integer.MIN_VALUE;
            left++;
        }
        return res;
    }

    public static void main(String args[]){
//        int[] result = new Solution239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        int[] result = new Solution239().maxSlidingWindow(new int[]{1,-1},1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}