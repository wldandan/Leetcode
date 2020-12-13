package com.wl.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class Solution567 {
    public boolean checkInclusion(String p, String s) {
        int left=0, right=0;
        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> window = new HashMap();

        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            need.put(c, need.getOrDefault(c,0)+1);
        }

        while(right < s.length()){
            Character c = s.charAt(right);
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
            }

            while(left <= right && isSame(window,need)){
                String tmp = s.substring(left,right+1);

                if (tmp.length() == p.length()) return true;

                Character d = s.charAt(left);
                if (need.containsKey(d)){
                    window.put(d, window.getOrDefault(d,0)-1);
                }
                left++;
            }

            right++;
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> window, Map<Character, Integer> need){
        if (window.size() != need.size()) return false;

        for (Character c :need.keySet()) {
            if (need.get(c) > window.get(c))
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(new Solution567().checkInclusion("adc","dcda"));
//        System.out.println(new Solution567().checkInclusion("ab","eidbaooo"));
//        System.out.println(new Solution567().checkInclusion("ab","eidboaoo"));
    }
}