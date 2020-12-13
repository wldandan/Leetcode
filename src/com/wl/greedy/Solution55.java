package com.wl.greedy;

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 ) return false;

        int maxReach = nums[0];
        int index = 0;
        while( index <= maxReach){
            maxReach = Math.max(maxReach,index + nums[index]);
            if (maxReach >= nums.length-1) return true;
            index++;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution55().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new Solution55().canJump(new int[]{}));
    }
}