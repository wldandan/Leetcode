package com.wl.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution438 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left=0, right=0;

        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            need.put(c, need.getOrDefault(c,0)+1);
        }

        while(right < s.length()){

            Character c = s.charAt(right);
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
            }

            while(left<right+1 && isSame(need, window)){

                String current = s.substring(left, right+1);
                if (current.length() == p.length()){
                    res.add(left);
                }

                Character d = s.charAt(left);
                if (need.containsKey(d)){
                    window.put(d, window.getOrDefault(d,0)-1);
                }

                left++;
            }

            right++;
        }

        return res;
    }

    private boolean isSame(Map<Character, Integer> need, Map<Character, Integer> window) {
        if (window.size() != need.size()) return false;

        for (Character c: need.keySet()) {
            if (need.get(c) > window.get(c)) return false;
        }
        return true;
    }

    public static void main(String args[]){
//        System.out.println(new Solution438().findAnagrams("cbaebabacd","abc"));
//        System.out.println(new Solution438().findAnagrams("abaacbabc","abc"));
        System.out.println(new Solution438().findAnagrams("acdcaeccde","c"));
    }
}