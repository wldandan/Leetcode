package com.wl.other;

import java.util.Stack;

class Solution227 {
    public int calculate(String s) {
        Stack<Character> stackOperator = new Stack();
        Stack<Integer> stackNum = new Stack();
        Integer currNum = 0;

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)){
                sb.append(String.valueOf(c));
            }

            else {
                stackNum.push(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                stackOperator.push(c);
                i++;

                if (stackOperator.peek() == '*') {
                    stackOperator.pop();
                    int value1 = stackNum.pop();
                    int value2 = 0;

                    while (i< chars.length && Character.isDigit(chars[i])) {
                        c = chars[i];
                        value2 = value2 * 10 + Integer.valueOf(String.valueOf(c));
                        i++;
                    }

                    int res = value1 * value2;
                    stackNum.push(res);
                } else if (stackOperator.peek() == '/') {
                    stackOperator.pop();
                    int value1 = stackNum.pop();
                    int value2 = 0;
                    while (i< chars.length && Character.isDigit(chars[i])) {
                        c = chars[i];
                        value2 = value2 * 10 + Integer.valueOf(String.valueOf(c));
                        i++;
                    }
                    int res = value1 / value2;
                    stackNum.push(res);
                }
            }
        }

        while (!stackOperator.isEmpty()){
            Character operator = stackOperator.pop();
            int value1 = stackNum.pop();
            int value2 = stackNum.pop();

            if (operator == '+') {
                stackNum.push(value1 + value2);
            }
            else if (operator == '-') {
                stackNum.push(value1 - value2);
            }
        }
        return stackNum.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution227().calculate("3+2*2"));
    }
}