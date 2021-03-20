package com.wl.string;

import java.util.Stack;


/*
由浅入深，单调栈思路去除重复字符
要求一、要去重。
要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果
https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
*/
class Solution316 {

    public String removeDuplicateLetters1(String s) {
        boolean[] isInStack = new boolean[256];
        int[] charsCount = new int[256];
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c: chars) {
            charsCount[c]++;
        }


        for (char c: chars) {
            charsCount[c]--;
            if (isInStack[c]) continue;

            while(!stack.isEmpty() && stack.peek() > c) {
                if (charsCount[stack.peek()] == 0) {
                    break;
                }
                isInStack[stack.pop()] = false;
            }
            stack.push(c);
            isInStack[c] = true;
        }

        StringBuilder build = new StringBuilder();
        while (!stack.empty()) {
            build.append(String.valueOf(stack.pop()));
        }
        return build.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters1("bcabc"));
        System.out.println(new Solution316().removeDuplicateLetters1("cbacdcbc"));

    }
}