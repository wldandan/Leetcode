package com.wl.string;

class Solution1545 {
    public char findKthBit(int n, int k) {
        int index = 0;
        String s0 = "0";
        while( index < n) {
            s0 = s0 + "1" + reverseAndInvert(s0);
            index++;
        }
        return s0.charAt(k-1);
    }

    private String reverseAndInvert(String s) {
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '0' ? '1' : '0';
            buffer.append(chars[i]);
        }

        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1545().findKthBit(3,1));
        System.out.println(new Solution1545().findKthBit(4,11));
        System.out.println(new Solution1545().findKthBit(1,1));
        System.out.println(new Solution1545().findKthBit(2,3));
    }
}