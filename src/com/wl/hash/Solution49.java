package com.wl.hash;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List <String>> results = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] characters = strs[i].toCharArray();
            Arrays.sort(characters);
            String curr = new String(characters);

            if (groups.containsKey(curr)){
                groups.get(curr).add(strs[i]);
            }
            else{
                List<String> item = new ArrayList <String>();
                item.add(strs[i]);
                groups.put(curr, item);
            }
        }

        for (Map.Entry item : groups.entrySet()) {
            results.add((List <String>) item.getValue());
        }
        return results;
    }

    public static void main(String[] args) {
        new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}