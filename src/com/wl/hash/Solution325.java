package com.wl.hash;

import java.util.HashMap;
import java.util.Map;

class Solution325 {

    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int idx = map.get(sum - k);
                res = Math.max(res, i - idx);
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return res;
    }

    public int maxSubArrayLen3(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        int[] preSum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
            if (map.containsKey(preSum[i+1] - k)) {
                int idx = map.get(preSum[i+1] - k);
                res = Math.max(res, i - idx);
            }
            if (!map.containsKey(preSum[i+1])){
                map.put(preSum[i+1], i+1);
            }
        }
        return res;
    }

    public int maxSubArrayLen2(int[] nums, int k) {
        int res = 0;
        int right = 0;
        int left = 0;
        while(right < nums.length) {
            while(calSum(nums, left, right) == k) {
                res = Math.max(res, right - left + 1);
                left++;
            }
            right++;
        }
        return res;
    }

    private int calSum(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution325().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));//4
        System.out.println(new Solution325().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));//2
    }
}