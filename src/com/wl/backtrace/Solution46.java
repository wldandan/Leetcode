package com.wl.backtrace;

import java.util.ArrayList;
import java.util.List;

class Solution46 {
    List<List<Integer>> results  = new ArrayList<>();
    List<Integer> path  = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrace(nums, path, visited);
        return results;
    }

    private void backtrace(int[] nums, List path, boolean[] visited){
        if (nums.length == path.size()){
            results.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
//            if (path.contains(nums[i])) continue;
            if (visited[i]) continue;


            path.add(nums[i]);
            visited[i] = true;

            backtrace(nums, path, visited);

            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        System.out.println(s.permute(new int[]{1,2,3}));
        System.out.println(s.results.size());

    }
}