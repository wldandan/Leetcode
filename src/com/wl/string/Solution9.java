package com.wl.string;

class Solution9 {
    public boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length()-1;
        boolean result = false;

        while (left <= right){
            if (str.charAt(left++) == str.charAt(right--)) {
                result = true;
            } else {
                result = false;
                return result;
            }

        }
        return result;
    }

    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public static void main(String[] args) {
        Solution9 s = new Solution9();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(10));
    }
}