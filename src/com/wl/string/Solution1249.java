package com.wl.string;

import java.util.*;

class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else list.add(i);
            }
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(i)) {
                buffer.append(s.charAt(i));
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1249().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new Solution1249().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new Solution1249().minRemoveToMakeValid("))(("));
        System.out.println(new Solution1249().minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(new Solution1249().minRemoveToMakeValid("abc"));

    }
}