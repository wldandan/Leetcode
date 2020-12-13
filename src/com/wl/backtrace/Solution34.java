package com.wl.backtrace;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int result = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid -1;
            }
            else if (nums[mid] == target) {
                result = mid;
                high = mid -1;
            }
        }
        return result;
    }

    private int searchRight(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int result = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid -1;
            }
            else if (nums[mid] == target) {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        System.out.println(s.searchRange(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(s.searchRange(new int[]{5,7,7,8,8,10}, 6));
    }
}