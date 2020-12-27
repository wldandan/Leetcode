package com.wl.string;

class Solution5629 {
    public String reformatNumber(String number) {

        number = number.replaceAll("-","");
        number = number.replaceAll(" ","");

        if (number.length() < 3) return number;

        StringBuffer list = new StringBuffer();


        char[] chars = number.toCharArray();

        boolean isIgnored3 = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            list.append(c);

            if (number.length() % 3 == 0 ) {
                if ((i+1) % 3 == 0 && i!=number.length()-1) {
                    list.append("-");
                }
            }
            else if (number.length() % 3 == 1) {
                if (i+4 == chars.length){
                    isIgnored3 = true;
                }
                if (isIgnored3 && i  == number.length() - 3) {
                    list.append("-");
                }
                if (!isIgnored3 && (i+1) % 3 == 0) {
                    list.append("-");
                }
            }
            else if (number.length() % 3 == 2) {
                if ((i+1) % 3 == 0) {
                    list.append("-");
                }
            }
        }

        return list.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution5629().reformatNumber("1-23-45 6"));
        System.out.println(new Solution5629().reformatNumber("123 4-567"));
        System.out.println(new Solution5629().reformatNumber("123 4-5678"));
        System.out.println(new Solution5629().reformatNumber("12"));
        System.out.println(new Solution5629().reformatNumber("--17-5 229 35-39475 "));
    }
}