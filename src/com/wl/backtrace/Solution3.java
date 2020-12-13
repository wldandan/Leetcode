package com.wl.backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        List<Character> results = new ArrayList<>();
        int length = 0;
        if (s.isEmpty()) return 0;

        for (int i = 0; i < s.toCharArray().length; i++) {
            Character curr = s.charAt(i);

            if (!results.contains(curr)){
                results.add(curr);
            }
            else{
                if (results.size() > length)
                    length = results.size();

                int index = results.lastIndexOf(curr);
                results = results.subList(index+1, results.size());
                results.add(curr);
            }
        }

        if (results.size() > length)
            length = results.size();

        return length;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution3().lengthOfLongestSubstring("bpfbhmipx"));
        System.out.println(new Solution3().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));

//        List<Character> results = new ArrayList<>();
//        results = results.subList(results.lastIndexOf(curr), results.size()-1);
    }
}