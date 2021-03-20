package com.wl.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> window = new HashMap();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);
            while(window.size() > 2) {
                c = s.charAt(left);
                int count = window.get(c)-1;
                if (count <=0) {
                    window.remove(c);
                }
                else {
                    window.put(c, count);
                }
                left++;
            }
            res = Math.max(res, right - left +1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct(""));
        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct("ab"));
    }
}