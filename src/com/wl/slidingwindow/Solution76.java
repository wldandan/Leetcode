package com.wl.slidingwindow;

import java.util.*;

class Solution76 {

    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int len = Integer.MAX_VALUE;
    int left=0;

    public String minWindow(String s, String t) {


        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) +1);
        }

        int sLen = s.length();
        int right = 0;
        int ansL = 0;
        int ansR = 0;

        while(right < sLen) {

            Character c = s.charAt(right);
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
            }

            while( left<=right && isSame()) {
                if (right-left +1 < len ){
                    len = right - left + 1;
                    ansL = left;
                    ansR = right + 1;
                }

                Character d = s.charAt(left);
                if (need.containsKey(d)){
                    window.put(d, window.getOrDefault(d,0)-1);
                }
                left++;
            }

            right++;
        }
        return s.substring(ansL, ansR);
    }

    private boolean isSame(){
        Iterator iter = need.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (window.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 s = new Solution76();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(s.minWindow("abc","cba"));
    }

}