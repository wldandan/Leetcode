package com.wl.array;

import java.util.HashSet;
import java.util.Set;

class Solution5630A {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int sum = 0;
        int start = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                res = Math.max(res, sum);
            } else {
                while(nums[start] != nums[i]) {
                    sum -=nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution5630A().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(new Solution5630A().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}