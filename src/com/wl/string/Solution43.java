package com.wl.string;


class Solution43 {
    public String multiply(String num1, String num2) {
        Double sum = 0.0;
        int digit = 1;
        for (int i = num2.length()-1; i >=0 ; i--) {
            sum += Double.valueOf(
                    Double.valueOf(num1) * Double.valueOf(String.valueOf(num2.charAt(i))) * digit);
            digit = digit * 10;
        }
        String res = String.valueOf(sum);
        int index = res.indexOf(".");
        return res.substring(0, index);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution43().multiply("2","3"));
//        System.out.println(new Solution43().multiply("123","456"));
//        System.out.println(new Solution43().multiply("0","3"));
        System.out.println(new Solution43().multiply("123456789","987654321"));
    }
}