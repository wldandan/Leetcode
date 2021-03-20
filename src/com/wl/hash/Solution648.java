package com.wl.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        Collections.sort(dictionary);
        boolean isMatched = false;
        for (int i = 0; i < words.length; i++) {
            isMatched = false;
            String word = words[i];
            for (int j = 0; j < dictionary.size(); j++) {
                if (word.isEmpty()) continue;
                if (word.startsWith(dictionary.get(j))){
                    isMatched = true;
                    builder.append(dictionary.get(j));
                    break;
                }
            }
            if (!isMatched) builder.append(word);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(
//            new Solution648().replaceWords(Arrays.asList("cat","bat","rat"),
//                    "the cattle was rattled by the battery"));
//
//        System.out.println(
//                new Solution648().replaceWords(Arrays.asList("a","b","c"),
//                        "adsfasf absbs bbab cadsfafs"));

        System.out.println(
                new Solution648().replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"),
                        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));

        System.out.println(
                new Solution648().replaceWords(Arrays.asList("catt","cat","bat","rat"),
                        "the cattle was rattled by the battery"));

        System.out.println(
                new Solution648().replaceWords(Arrays.asList("ac","ab"),
                        "it is abnormal that this solution is accepted"));

    }
}