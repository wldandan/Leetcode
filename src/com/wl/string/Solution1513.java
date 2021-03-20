package com.wl.string;

class Solution1513 {
    public int numSub(String s) {
        String[] strs = s.split("0");
        int res = 0;
        for (String str: strs) {
            double a = (double)str.length();
            double b = (double)str.length() + 1;
            int mode = (int)(1e9+7);
            res += (a * b /2) % mode;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1513().numSub("0110111"));
        System.out.println(new Solution1513().numSub("111111"));
        System.out.println(new Solution1513().numSub("000"));
    }
}