package com.wl.string;

class Solution8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        StringBuffer sb = new StringBuffer();
        int digit = 1;

        Character firstC = str.charAt(0);

        if (firstC =='-') {
            digit = -1;
        }
        else if (firstC < '0' || firstC >'9'){
            return 0;
        }
        else {
            sb.append(firstC);
        }

        for (int i = 1; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isDigit(c) ){
                sb.append(c);
            }else break;
        }

        if (sb.toString().isEmpty()) return 0;
        long result = Long.valueOf(sb.toString()) * digit;
        if (result > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE ) return Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("       -42"));
        System.out.println(s.myAtoi("words and 987"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi("-91283472332"));

    }
}