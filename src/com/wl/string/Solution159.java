package com.wl.string;

import java.util.HashSet;
import java.util.Set;

class Solution159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();

        char[] chars = s.toCharArray();
        char pre = chars[left];
        set.add(pre);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == pre) {
                right++;
                continue;
            }
            else {
                set.add(c);
                pre = c;
            }
            if (set.size() == 3) {
                res = Math.max(res, i - left);
                set.remove(s.charAt(left));
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == s.charAt(left)) {
                        left++;
                    }
                }
            }
        }
        return res;
    }


    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int left = 0;
        int[] charCount = new int[s.length()];
        char[] chars = s.toCharArray();
        char pre = chars[0];
        for (int right = 1; right < chars.length; right++) {
            if (pre != chars[right]) {
                pre = chars[right];
                charCount[left++] = right;
            }
        }
        charCount[left++] = s.length();

        int res = 0;
        for (int i = 0; i < charCount.length-2; i++) {
            int tmp = (charCount[i+2]  - charCount[i+1]) + (charCount[i+1]  - charCount[i]);
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new Solution159().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}