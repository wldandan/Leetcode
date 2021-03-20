package com.wl.string;

class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        if (isEchoStr(a) || isEchoStr(b)) return true;
        if (a.charAt(0) == b.charAt(b.length()-1)) return true;
        if (a.charAt(a.length()-1) == b.charAt(0)) return true;
        return false;
    }

    private boolean isEchoStr(String s) {
        return new StringBuffer(s).reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1616().checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(new Solution1616().checkPalindromeFormation("abdef", "fecab"));
        System.out.println(new Solution1616().checkPalindromeFormation("x", "y"));
        System.out.println(new Solution1616().checkPalindromeFormation("xbdef", "xecab"));
    }
}