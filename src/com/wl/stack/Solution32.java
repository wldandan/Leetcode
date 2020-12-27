package com.wl.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution32 {
    private static char LEFT_BRACKET = '(';
    private static char RIGHT_BRACKET = ')';

    public int longestValidParentheses(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("))(()"));
//        System.out.println(new Solution32().longestValidParentheses(")()())"));
//        System.out.println(new Solution32().longestValidParentheses("())()()()("));
//        System.out.println(new Solution32().longestValidParentheses("()(())"));
    }
}