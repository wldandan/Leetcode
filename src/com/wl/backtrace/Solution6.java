package com.wl.backtrace;

import java.util.ArrayList;
import java.util.List;

class Solution6 {
    public String convert(String s, int numRows) {

        if(numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int cursor = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            rows.get(cursor).append(curr);
            if(cursor == 0 || cursor == numRows -1) flag = - flag;
            cursor = cursor + flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public String convert2(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("LEETCODEISHIRING",3));
        System.out.println(new Solution6().convert2("LEETCODEISHIRING",3));
    }
}