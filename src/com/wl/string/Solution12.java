package com.wl.string;

class Solution12 {
    public String intToRoman(int num) {
        String[] alphas = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuffer buff = new StringBuffer();

        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (num >= values[i]) {
                    num = num - values[i];
                    buff.append(String.valueOf(alphas[i]));
                    break;
                }

            }
        }

        return buff.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution12().intToRoman(3));
//        System.out.println(new Solution12().intToRoman(4));
//        System.out.println(new Solution12().intToRoman(9));
//        System.out.println(new Solution12().intToRoman(58));
//        System.out.println(new Solution12().intToRoman(1994));
        System.out.println(new Solution12().intToRoman(3998));

    }
}