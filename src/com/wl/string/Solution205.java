package com.wl.string;

import java.util.HashMap;
import java.util.Map;

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if ( s == null || t == null ) return false;

        return isMatched(s, t) && isMatched(t, s);
    }

    private boolean isMatched(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char source = s.charAt(i);
            char dest = t.charAt(i);

            if (!map.containsKey(source)){
                map.put(source, dest);
            }
            else {
                Character c = map.get(source);
                if (c != dest) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution205().isIsomorphic("ab", "aa"));
        System.out.println(new Solution205().isIsomorphic("egg", "add"));
        System.out.println(new Solution205().isIsomorphic("foo", "bar"));
        System.out.println(new Solution205().isIsomorphic("paper", "title"));
    }
}