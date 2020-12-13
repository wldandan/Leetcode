package com.wl.string;

import java.util.HashMap;
import java.util.Map;

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (Character c: magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args){
        Solution383 s = new Solution383();
        System.out.println(s.canConstruct("a", "b"));
        System.out.println(s.canConstruct("aa", "ab"));
        System.out.println(s.canConstruct("aa", "aab"));
        System.out.println(s.canConstruct("aab", "aba"));
    }
}