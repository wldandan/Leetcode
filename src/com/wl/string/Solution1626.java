package com.wl.string;

import java.util.Stack;

class Solution1626 {
    public int calculate(String s) {
        char op = '+';
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c!=' ' || i == chars.length-1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;

                    case '-':
                        stack.push(-num);
                        break;

                    case '*':
                        stack.push(stack.pop() * num);
                        break;

                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                op = c;
                num = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1626().calculate("3+2*2"));
        System.out.println(new Solution1626().calculate("3/2"));
        System.out.println(new Solution1626().calculate("3+5/2"));
    }
}