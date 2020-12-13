package com.wl.twopointer;

import java.util.*;

/*
* 2sum的改良版
* 1)实现了对元素的去重
* 2)实现了left起点的位置的自定义
* */

class Solution1A {

    public List<List<Integer>> twoSum(int[] nums, int target) {
        return this.twoSum(nums, target,0);
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int left = start;
        int right = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        while (left < right){
            int lo = nums[left];
            int hi = nums[right];
            int sum = lo + hi;
            if (sum < target) {
                while ( left <= right && lo == nums[left]) { left++; }
            }
            else if (sum > target) {
                while ( left <= right && hi == nums[right]) { right--; }
            }
            else {
                res.add(new ArrayList(Arrays.asList(lo, hi)));
                while ( left <= right && lo == nums[left]) { left++; }
                while ( left <= right && hi == nums[right]) { right--; }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1A s = new Solution1A();
        System.out.println(s.twoSum(new int[]{3,2,2,3,4,4}, 6));
    }
}