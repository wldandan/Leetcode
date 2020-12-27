package com.wl.array;

import java.util.HashSet;
import java.util.Set;

class Solution5630A2 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;

        int left = 0, right = 0, sum = 0, res = 0;
        //sum是[left, right]的和
        while(left < len && right < len) {
            //将要加入set的数
            int num = nums[right];
            if(set.contains(num)) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }else {
                sum += num;
                set.add(num);
                right++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution5630A().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(new Solution5630A2().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}