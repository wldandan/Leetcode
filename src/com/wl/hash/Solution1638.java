package com.wl.hash;

class Solution1638 {
    public int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                String subS = s.substring(i, j);
                for (int k = 0; k < t.length()-subS.length()+1; k++) {
                    String subT = t.substring(k, k+subS.length());
                    if (isOnlyOneCharacterDifferent(subS, subT)) {
//                        System.out.println("subS :"+ subS + "/ subT:" + subT);
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean isOnlyOneCharacterDifferent(String subS, String subT) {
        if (subS.length() != subT.length()) return false;
        int differentCount = 0;
        for (int i = 0; i < subS.length(); i++) {
            if (subS.charAt(i) != subT.charAt(i)) differentCount++;
            if (differentCount > 1) return false;
        }
        return differentCount == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1638().countSubstrings("aba", "baba"));
        System.out.println(new Solution1638().countSubstrings("ab", "bb"));
        System.out.println(new Solution1638().countSubstrings("a", "a"));
        System.out.println(new Solution1638().countSubstrings("abe", "bbc"));
    }
}