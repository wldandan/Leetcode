package com.wl.stack;

import java.util.Stack;

class Solution394A {

    public String decodeString(String s) {
        int times = 0;
        StringBuilder res = new StringBuilder();

        StringBuilder strBuff = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> timeStack = new Stack<>();


        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)){
                times = times * 10 + Integer.valueOf(String.valueOf(c));
            }
            else if (Character.isLetter(c)){
                strBuff.append(String.valueOf(c));
            }
            else if (c == '>') {
                timeStack.push(times);
                times = 0;
            }
            else if (c == '(') {
                strStack.push(strBuff);
                strBuff = new StringBuilder();
            }
            else if (c == ')') {
                if (!strBuff.toString().isEmpty()){
                    strStack.push(strBuff);
                    strBuff = new StringBuilder();
                }

                if (!strStack.isEmpty()){
                    String str = combineStrAndTimes(strStack, timeStack);
                    strStack.peek().append(str);

                    if (timeStack.isEmpty()){
                        res.append(str);
                    }
                }
            }
        }

        if (!strBuff.toString().isEmpty()){
            res.append(strBuff.toString());
        }
        return res.toString();

    }

    private String combineStrAndTimes(Stack<StringBuilder> strStack, Stack<Integer> timeStack) {
        StringBuilder res = new StringBuilder();
        Integer tmpTimes = timeStack.pop();
        StringBuilder tmpStrBuff = strStack.pop();

        for (int i = 0; i < tmpTimes; i++) {
            res.append(tmpStrBuff.toString());
        }
        return res.toString();
    }


    public static void main(String[] args) {
//        System.out.println(new Solution394A().decodeString("3[a]2[bc]ef"));
//        System.out.println(new Solution394A().decodeString("3[a2[c]]"));
//        System.out.println(new Solution394A().decodeString("(c(ab)<3>)<2>"));
        System.out.println(new Solution394A().decodeString("(ab)<2>"));
    }
}