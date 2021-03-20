package com.wl.hash;

class MagicDictionary {
    private String[] dictionary;
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (int i = 0; i < dictionary.length; i++) {
            String src = dictionary[i];
            if (isOnlyOneCharDifferent(src, searchWord)) return true;
        }
        return false;
    }

    private boolean isOnlyOneCharDifferent(String src, String dest) {
        if (src.length() != dest.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != dest.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}