package com.wl.greedy;

import java.util.Stack;

class Solution316 {
    /*
    * 1. 使用inStack判断是否出现重复
    * 2. 使用单调栈确保顺序
    * 3. 如果后面还有,则前面的可以出来
    * */
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        boolean[] inStack = new boolean[256];


        Stack<Character> stack = new Stack<>();
        int[] charCount = new int[256];

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            charCount[c]++;
        }



        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            charCount[c]--;
            if (inStack[c]) continue;

            while(!stack.isEmpty() && stack.peek() > c ){
                if (charCount[stack.peek()] == 0) break;

                if (charCount[stack.peek()] > 0 )
                    inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution316().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution316().removeDuplicateLetters("ecbacba"));
        System.out.println(new Solution316().removeDuplicateLetters("leetcode"));


    }
}