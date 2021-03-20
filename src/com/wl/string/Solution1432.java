package com.wl.string;

class Solution1432 {
    public int maxDiff(int num) {
        String maxNum = getLargestNum(num);
        String minNum = getSmallestNum(num);

        return Integer.valueOf(maxNum) - Integer.valueOf(minNum);
    }

    private String getSmallestNum(int num) {
        String firstDigit = String.valueOf(num).substring(0,1);
        char[] chars = String.valueOf(num).toCharArray();
        int index = -1;
        if (firstDigit.equals("1")) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '1' && chars[i] > '0') {
                    index = i;
                    firstDigit = String.valueOf(chars[i]);
                    break;
                }
            }
            if (index != -1) {
                return String.valueOf(num).replace(firstDigit, "0");
            }
        }
        else {
            return String.valueOf(num).replace(firstDigit, "1");
        }
        return String.valueOf(num);
    }

    private String getLargestNum(int num) {
        String firstDigit = String.valueOf(num).substring(0,1);
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '9') {
                firstDigit = String.valueOf(chars[i]);
                break;
            }
        }
        return String.valueOf(num).replace(firstDigit, "9");
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1432().maxDiff(555));
//        System.out.println(new Solution1432().maxDiff(9));
//        System.out.println(new Solution1432().maxDiff(123456));
//        System.out.println(new Solution1432().maxDiff(10000));
        System.out.println(new Solution1432().maxDiff(1101057));
        System.out.println(new Solution1432().maxDiff(111));
    }
}