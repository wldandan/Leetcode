package com.wl.string;

import java.util.Arrays;

class Solution1713 {
    public int respace(String[] dictionary, String sentence) {
        Arrays.sort(dictionary, (x,y)->y.length() - x.length());
        for (String word : dictionary) {
            sentence = sentence.replace(word, "");
        }
        System.out.println(sentence);
        return sentence.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1713().respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));

    }
}