package com.wl.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] res = s.twoSum(new int[]{3,2,4}, 6);
        System.out.println(res[0] + ":" + res[1]);
    }
}