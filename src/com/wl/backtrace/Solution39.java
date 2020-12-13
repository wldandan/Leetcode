package com.wl.backtrace;

import java.util.*;

class Solution39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, new LinkedList<>());

        return res;
    }

    private void backtrace(int[] candidates, int target, int start, LinkedList<Integer> track){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(target < candidates[i]) break;
            track.add(candidates[i]);
            backtrace(candidates, target - candidates[i], 0, track);
            track.removeLast();
        }
    }

    private void backtrace2(int target, int[] candidates, List<Integer> track) {
        int tmp = sum(track);

        if (tmp >= target){
            List<Integer> result = new ArrayList<>(track);
            Collections.sort(result);
            if ((tmp==target) && !isExisted(res, result)) res.add(result);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrace2(target, candidates,track);
            track.remove(track.size()-1);
        }

    }

    private int sum(List<Integer> lists){
        int res = 0;
        for (int i = 0; i < lists.size(); i++) {
            res = res + lists.get(i);
        }
        return res;
    }

    public Boolean isExisted(List<List<Integer>> results, List<Integer> lists){
        boolean isExisted;
        if (results.isEmpty()) return false;

        for (int i = 0; i < results.size(); i++) {
            List<Integer> current = results.get(i);

            if (current.size() == lists.size()){
                isExisted = true;
                for (int j = 0; j < lists.size(); j++) {
                    isExisted = isExisted && current.get(j).equals(lists.get(j));
                    if (!isExisted) break;
                }
                if (isExisted) return true;
            }
            else continue;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2,3,6,7},7));
        System.out.println(new Solution39().combinationSum(new int[]{2,3,5},8));
        System.out.println(new Solution39().combinationSum(new int[]{8,7,4,3},11));
    }
}