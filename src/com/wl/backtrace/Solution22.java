package com.wl.backtrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution22 {

    List<String> res = new ArrayList<>();
    String[] parentheses = new String[]{"((","()","))",")("};

    public List<String> generateParenthesis(int n) {

        StringBuffer sb = new StringBuffer();
        backtrace(0, sb, n);
        return res;
    }

    private void backtrace(int depth, StringBuffer sb, int n) {
        //判断长度
        if (sb.length() == n*2) {
            //判断是否合理
            if (isValid(sb.toString())) {
                res.add(sb.toString());
            }
            //必须
            return;
        }

        for (int j = 0; j < parentheses.length; j++) {
            sb.append(parentheses[j]);
            backtrace(depth+1, sb, n);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    private Boolean isValid(String s){
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current.equals('(')){
                stack.push(current);
            }
            else if (current.equals(')')){
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}