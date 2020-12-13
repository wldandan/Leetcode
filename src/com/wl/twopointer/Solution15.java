package com.wl.twopointer;

import java.util.*;

/*
* 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

/*
* 利用2sum的实现,将3sum为0转变成 (2sum + (-target)),然后使用Map(-target作为key, 2sum作为value),最后组装而成.
* */

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = twoSum(nums, -nums[i], i+1);
            if (!tmp.isEmpty() && !map.containsKey(nums[i])){
                map.put(nums[i],tmp);
            }
        }

        for (Integer key: map.keySet()) {
            List<List<Integer>> item = map.get(key);
            for (int i = 0; i < item.size(); i++) {
                item.get(i).add(key);
                res.add(item.get(i));
            }
        }
        return res;
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
        Solution15 s = new Solution15();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{1, 2, -2, -1}));

    }
}