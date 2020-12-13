package com.wl.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int left=0,right=0;
        int len = 0;

        Map<Character,Integer> map = new HashMap<>();

        while(right < s.length()){
            Character c = s.charAt(right);
            if (map.containsKey(c)){
                left = Math.max(map.get(c), left);
            }
            len = Integer.max(len, right - left +1);
            right++;
            map.put(c, right);
        }

        return len;
    }

    public static void main(String args[]){
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("tmmzuxt"));
    }
}