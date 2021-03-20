package com.wl.string;

import java.util.HashMap;
import java.util.Map;

class Solution1297Error {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chars = s.toCharArray();
        int res = 0;
        Map<String, Integer> resMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);
            right++;

            while(window.size() <= maxLetters && (right-left)>=minSize && (right-left)<=maxSize) {
                String curr = s.substring(left, right);
                resMap.put(curr, resMap.getOrDefault(curr,0)+1);

                c = s.charAt(left);
                left++;
                int value = window.get(c);
                value = value - 1;
                if (value == 0) window.remove(c);
                else window.put(c, value);
            }

            if (window.size() > maxLetters || (right-left)>maxSize) {
                left++;
                int value = window.get(c);
                value = value - 1;
                if (value == 0) window.remove(c);
                else window.put(c, value);
            }
        }
        return resMap.values().stream().sorted().findFirst().get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1297Error().maxFreq("aababcaab", 2, 3, 4));
    }
}