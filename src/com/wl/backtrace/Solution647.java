package com.wl.backtrace;

class Solution647 {

    StringBuffer sb = new StringBuffer();
    int res = 0;

    public int countSubstrings(String s) {

        if (s.isEmpty()) return 0;
        backtrace(s, sb, 0);
        return res-1;

    }

    private void backtrace(String s, StringBuffer sb, int start) {
        if (!isEcho(sb)) return;

        System.out.println(sb.toString());

        if (sb.length() == s.length()) {
            if (isEcho(sb)){
                res++;

            }
            return;
        }



        res++;



        for (int i = start; i < s.length(); i++) {
            sb.append(String.valueOf(s.charAt(i)));
            backtrace(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private boolean isEcho(StringBuffer sb){
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
//        System.out.println(new Solution647().countSubstrings("abc"));
//        System.out.println(new Solution647().countSubstrings("a"));
        System.out.println(new Solution647().countSubstrings("aaa"));

    }
}