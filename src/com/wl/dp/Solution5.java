package com.wl.dp;

import java.util.Arrays;

class Solution5 {
    /*
    * dp[i][j]表示 S从i,j的字符串是否是回文字符串
    * 如果是,则[i+1][j-1] && s[i]==s[j]则也是回文字符串
    * 因此 dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
    * */
    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;


        int n = s.length();
        int maxLen = 1;
        int begin = 0;
        String res = null;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
                dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }
                else {
                    //如果j-i+1 < 2,则表示字符串长度只有1位
                    if ((j - i) < 3) dp[i][j] = true;

                    //只有当长度>2时,dp[i][j] = dp[i+1][j-1];
                    else dp[i][j] = dp[i+1][j-1];
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        res = s.substring(begin, begin + maxLen);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("babad"));
        System.out.println(new Solution5().longestPalindrome("cbbd"));
        System.out.println(new Solution5().longestPalindrome("ac"));
    }
}