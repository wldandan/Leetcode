package com.wl.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String word:dictionary) {
            String key = convert(word);
            Set<String> set = map.getOrDefault(key, new HashSet<>());
            set.add(word);
            map.put(key, set);
        }
    }

    private String convert(String word) {
        if (word.length() < 3) return word;
        StringBuilder build = new StringBuilder();
        build.append(word.charAt(0));
        build.append(word.length()-2);
        build.append(word.charAt(word.length()-1));
        return build.toString();
    }

    public boolean isUnique(String word) {
        String key = convert(word);
        return map.containsKey(key) ? map.get(key).size()==1 && map.get(key).contains(word) : true;
    }

    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
    }
}