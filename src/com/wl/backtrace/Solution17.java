package com.wl.backtrace;

import java.util.*;

class Solution17 {

    Map<String, String> digitMap = new HashMap<>();
    List<String> res = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    public Solution17(){
        digitMap.put("0", "");
        digitMap.put("1", "");
        digitMap.put("2", "abc");
        digitMap.put("3", "def");
        digitMap.put("4", "ghi");
        digitMap.put("5", "jkl");
        digitMap.put("6", "mno");
        digitMap.put("7", "pqrs");
        digitMap.put("8", "tuv");
        digitMap.put("9", "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            lists.add(digitMap.get(String.valueOf(digits.charAt(i))));
        }

        StringBuffer sb = new StringBuffer();
        backtrace(digits, 0, sb);
        return res;
    }

    private void backtrace(String digits, Integer depth, StringBuffer sb){
        if (digits.length() == depth){
                res.add(sb.toString());
            return;
        }

        String current = digitMap.get(String.valueOf(digits.charAt(depth)));
        for (int j = 0; j < current.length(); j++) {
            sb.append(current.charAt(j));
            backtrace(digits, depth+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private void backtrace2(List<String> lists, Integer depth, StringBuffer sb){
        if (lists.size() == depth){
            if (!res.contains(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }

        for (int i = depth; i < lists.size(); i++) {
            String current = lists.get(i);
            for (int j = 0; j < current.length(); j++) {
                sb.append(current.charAt(j));
                backtrace2(lists, depth+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }

    public static void main(String args[]){
        System.out.println(new Solution17().letterCombinations("23"));
    }
}