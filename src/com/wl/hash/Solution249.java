package com.wl.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            String convertKey = convert(word);
            List<String> list = map.getOrDefault(convertKey,new ArrayList<>());
            list.add(word);
            map.put(convertKey, list);
        }
        List<List<String>> res = new ArrayList<>();
        map.values().forEach(x->res.add(x));
        return res;
    }

    private String convert(String word) {
        StringBuilder build = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            int index = (word.charAt(i) - word.charAt(i-1) + 26) % 26;
            build.append(index);
            build.append(",");
        }
        return build.toString();
    }

    public static void main(String[] args) {
        System.out.println(
            new Solution249().groupStrings(
                    new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}