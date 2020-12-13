package com.wl.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class Solution3A {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0;
        int len=0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()){
            Character c = s.charAt(right);

            if (map.containsKey(c)){
                left = Math.max(left, map.get(c));
            }
            len = Math.max(len, right-left+1);
            right++;
            map.put(c, right);
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3A().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3A().lengthOfLongestSubstring("bbbbbb"));
        System.out.println(new Solution3A().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution3A().lengthOfLongestSubstring("dudf"));
    }
}