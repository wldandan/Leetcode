package com.wl.string;

class Solution1759 {
    public int countHomogenous(String s) {
        int len=s.length();
        int mod=(int)(1e9+7);
        long count=0;
        int left=0,right=0;
        while (left<len){
            char ch=s.charAt(left);
            right = left;
            while (right<len && s.charAt(right)==ch) right++; //往后找连续相同的
            long n=right-left; //之前一直用int，然后下面乘那里溢出了
            count +=  n*(n+1)/2;
            left=right;
        }
        return (int) (count%mod);
    }

    public int findSlideWinPosLeft(String s){
        int res = 0;
        double mod = 1e9+7;
        int len = s.length();
        int left = 0;
        int right = 0;
        while (right <= len) {
            if (right == len || s.charAt(left) != s.charAt(right)) {
                res += (right - left) * (right - left+1)/2;
                left = right;
            }
            right++;
        }
        return (int)(res % mod);
    }


    public int findSlideWinPos(String s){
        long res = 0;
        int mod = (int)(1e9+7);
        int len = s.length();
        int left = 0;
        int right = 0;
        while (left < len) {
            char ch=s.charAt(left);
            while(right < len && s.charAt(right) == ch) {
                right++;
            }
            long count = right - left;
            res += count * (count+1)/2;
            left = right;
        }
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1759().findSlideWinPos("abbcccaa"));
        System.out.println(new Solution1759().findSlideWinPos("xy"));
        System.out.println(new Solution1759().findSlideWinPos("zzzzz"));
    }
}