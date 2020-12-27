package com.wl.array;

import java.util.HashMap;
import java.util.Map;

class Solution5630 {
    public int maximumUniqueSubarray(int[] nums) {

        Map<Integer, Integer> map;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            map = new HashMap<>();
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (map.containsKey(nums[j])){
                    break;
                }
                sum += nums[j];
                map.put(nums[j],1);
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5630().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(new Solution5630().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}