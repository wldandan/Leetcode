package com.wl.backtrace;

import java.util.Arrays;

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        double result = 0.00;
        int[] nums = new int[length];

        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            nums[nums1.length+i] = nums2[i];
        }

        Arrays.sort(nums);

        if (length % 2 == 0){
            result = (nums[length/2 -1] + nums[(length/2+1)-1]) / 2.0;
        }
        else{
            result = nums[(length+1)/2 -1];
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution4().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(new Solution4().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}