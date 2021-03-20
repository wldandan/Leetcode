package com.wl.string;

class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;

        int len = Math.abs(s.length() - t.length());
        if (len > 1) return false;
        else if (len == 0 ) {
            if (s.equals(t)) return false;
            return isOnlyOneDifferentWithSameLength(s,t);
        }
        else if (len == 1) {
            return isOnlyOneDifferentWithDiffLength(s,t);
        }
        return false;
    }

    private boolean isOnlyOneDifferentWithDiffLength(String s, String t) {
        String longStr = s.length() > t.length() ? s : t;
        String shortStr = s.length() < t.length() ? s : t;

        if (longStr.indexOf(shortStr) >= 0) return true;

        if (shortStr.isEmpty()) return true;

        int diffIndex = -1;
        for (int i = 0; i < shortStr.length(); i++) {
            if (shortStr.charAt(i) != longStr.charAt(i)) {
                diffIndex = i;
                break;
            }
        }
        if (diffIndex >=0) {
            String newStr = longStr.substring(0, diffIndex) + longStr.substring(diffIndex+1, longStr.length());
            return newStr.equals(shortStr);
        }

        return false;
    }

    private boolean isOnlyOneDifferentWithSameLength(String s, String t) {
        int index = 0;
        int diff = 0;
        while(index < s.length()) {
            if (s.charAt(index) != t.charAt(index)) diff++;
            if (diff > 1) return false;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution161().isOneEditDistance("a", "A"));
        System.out.println(new Solution161().isOneEditDistance("a", ""));
        System.out.println(new Solution161().isOneEditDistance("ab", "acb"));
        System.out.println(new Solution161().isOneEditDistance("cab", "ad"));
    }
}