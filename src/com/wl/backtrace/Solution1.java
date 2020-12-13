package com.wl.backtrace;

import java.util.Arrays;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        return this.twoSumWay2(nums, target);
    }

    private int[] twoSumWay(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        int[] result = new int[]{-1, -1};


        for (int i = left, j=right; i < j; i++) {

        }
        while(left <= right){
            int sum = nums[left] + nums[right];

            if (sum == target){
                result[0] = left;
                result[1] = right;
                break;
            }
            else if (sum > target){
                right--;
            }
            else if (sum < target){
                left++;
            }
        }
        return result;
    }

    private int[] twoSumWay2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] s = new Solution1().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(s[0]);
        System.out.println(s[1]);

    }
}