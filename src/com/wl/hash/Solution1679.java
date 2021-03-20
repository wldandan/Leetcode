package com.wl.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        int right = nums.length-1;
        int res = 0;
        while(left < right) {
            if (nums[left] + nums[right] == k) {
                res++;
                left++;
                right--;
            }
            else if (nums[left] + nums[right] > k) right--;
            else if (nums[left] + nums[right] < k) left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1679().maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(new Solution1679().maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}