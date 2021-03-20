package com.wl.string;

import java.util.ArrayList;
import java.util.List;

class Solution816 {
    public List<String> ambiguousCoordinates(String S) {
        int len = S.length();
        // 去除两个括号
        S = S.substring(1, len - 1);
        List<String> res = new ArrayList<>();
        List<String> left;
        List<String> right;
        // 因为去除了两个括号 所以字符串长度要减少2
        len -= 2;
        for (int i = 0; i < len - 1; i++) {
            left = helper(S.substring(0, i + 1));
            right = helper(S.substring(i + 1));
            if (left.size() == 0 || right.size() == 0) {
                continue;
            }
            for (String l : left) {
                for (String r : right) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(").append(l).append(", ").append(r).append(")");
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    private static List<String> helper(String str) {
        List<String> list = new ArrayList<>();
        int len = str.length();
        // 当以0末尾
        if (str.charAt(len - 1) == '0') {
            //如果长度为0的时,放进res
            if (len == 1) {
                list.add("0");
            //如果开头不为0,则直接放入
            } else if (str.charAt(0) != '0') {
                list.add(str);
            }
            return list;
        }

        //如果开头为0,则加入小数点,直接放入
        if (str.charAt(0) == '0') {
            list.add("0." + str.substring(1));
            return list;
        }
        list.add(str);
        StringBuilder sb;
        for (int i = 0; i < len - 1; i++) {
            sb = new StringBuilder();
            sb.append(str, 0, i + 1).append('.').append(str.substring(i + 1));
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution816().ambiguousCoordinates("(1230)"));
        System.out.println(new Solution816().ambiguousCoordinates("(00011)"));
    }
}