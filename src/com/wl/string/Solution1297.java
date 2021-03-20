package com.wl.string;

import java.util.HashMap;
import java.util.Map;

class Solution1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - minSize; i++) {
            String curr = s.substring(i, i+minSize);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (isValid(entry.getKey(), maxLetters) && entry.getValue() > res){
                res = entry.getValue();
            }

        }
        return res;
    }

    private boolean isValid(String str, int maxLetters) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c: str.toCharArray()) {
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }
        return characterIntegerMap.size() <= maxLetters;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1297().maxFreq("aababcaab", 2,3,4));
        System.out.println(new Solution1297().maxFreq("aaaa", 1,3,3));
        System.out.println(new Solution1297().maxFreq("aabcabcab", 2,2,3));
        System.out.println(new Solution1297().maxFreq("abcde", 2,3,3));
    }
}