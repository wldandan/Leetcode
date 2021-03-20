package com.wl.array;

import java.util.Arrays;

class Solution31 {
    public void nextPermutation(int[] nums) {
        int firstIndex = -1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i>=1 && nums[i-1] < nums[i]) {
                firstIndex = i-1;
                break;
            }
        }

        int secondIndex = -1;
        if (firstIndex != -1) {
            for (int i = nums.length-1; i >=0 ; i--) {
                if (nums[i] > nums[firstIndex]) {
                    secondIndex = i;
                    break;
                }
            }
            swap(nums, firstIndex, secondIndex);
        }

        Arrays.sort(nums, firstIndex+1, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        if (firstIndex == -1 || secondIndex == -1) return;

        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public static void main(String[] args) {
        new Solution31().nextPermutation(new int[]{1,2,3});
        new Solution31().nextPermutation(new int[]{3,2,1});
        new Solution31().nextPermutation(new int[]{1,1,5});
        new Solution31().nextPermutation(new int[]{1});
    }
}