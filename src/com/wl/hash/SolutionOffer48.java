package com.wl.hash;

import java.util.HashMap;
import java.util.Map;

class SolutionOffer48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int index = 0;
        int left = 0;
        for(char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            map.put(c, index);
            res = Math.max(res, index - left);
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("pwwkew"));
    }
}