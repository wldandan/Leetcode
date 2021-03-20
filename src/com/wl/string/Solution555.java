package com.wl.string;

class Solution555 {
    public String splitLoopedString(String[] strs) {
        //Step1 得到字典序最大的字符串
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String reversed = new StringBuffer(s).reverse().toString();
            if (reversed.compareTo(s) > 0 ) strs[i] = reversed;
        }

        String ans = "";

        for (int i = 0; i < strs.length; i++) {
            //Step2 取出当前的字符串
            String curr = strs[i];
            StringBuffer buffer = new StringBuffer();
            //Step3 拼接其后面的字符串
            for (int j = i+1; j < strs.length; j++) {
                buffer.append(strs[j]);
            }

            //Step4 拼接其前面的字符串
            for (int j = 0; j < i; j++) {
                buffer.append(strs[j]);
            }

            //Step5 在当前字符串中依次循环,从断点位置开始分割
            for (int j = 0; j < curr.length(); j++) {
                String tmp = curr.substring(j) + buffer.toString() + curr.substring(0, j);
                if (tmp.compareTo(ans) > 0) {
                    ans = tmp;
                }
            }

            //Step5 在反转字符串中依次循环,从断点位置开始分割
            String reversed = new StringBuffer(curr).reverse().toString();
            for (int j = 0; j < reversed.length(); j++) {
                String tmp = reversed.substring(j) + buffer.toString() + reversed.substring(0, j);
                if (tmp.compareTo(ans) > 0) {
                    ans = tmp;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution555().splitLoopedString(new String[]{"abc", "xyz"}));
    }
}