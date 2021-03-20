package com.wl.string;

/*
* 1. 将所有字符串转换成XmYn的格式
* 2. 对比
*   - 如果长度不相等,则不匹配
*   - 如果长度相等,字符不相等,不匹配
*   - 如果长度相等,字符匹配,S中的数字>=3 且 S中的数字-Word中的数字 > 1则匹配,结果+1
* */

class Solution809 {
    public int expressiveWords(String S, String[] words) {
        if (S.isEmpty()) return 0;

        int res = 0;
        String convertedString = convert(S);
        for (String word : words) {
            String convertedWord = convert(word);

            if (isValid(convertedString, convertedWord)) {
                res++;
            }
        }
        return res;
    }

    public String convert(String word) {
        if (word == null || word.length() == 0) {
            return "";
        }

        char[] chars = word.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        char c = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c ) {
                count++;
            }
            else {
                buffer.append(c);
                buffer.append(count);
                c = word.charAt(i);
                count = 1;
            }
        }
        buffer.append(c);
        buffer.append(count);
        return buffer.toString();
    }

    private boolean isValid(String str, String word) {
        if (word.length() != str.length()) return false;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 != 0) {
                if (str.charAt(i) != word.charAt(i)) {
                    boolean isDiff = Integer.valueOf(str.charAt(i)-'0') >= 3
                    && Integer.valueOf(str.charAt(i)-'0') - Integer.valueOf(word.charAt(i)-'0') >= 1;
                    if (!isDiff) return false;
                }
            }
            else {
                if (str.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution809().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(new Solution809().expressiveWords("dddiiiinnssssssoooo",
                new String[]{"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));
        System.out.println(new Solution809().expressiveWords("abcd", new String[]{"abc"}));
    }
}