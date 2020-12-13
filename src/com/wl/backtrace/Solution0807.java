package com.wl.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution0807 {
    private List<String> res = new ArrayList<>();

    public String[] permutation(String S) {
        if (S==null || S.isEmpty()) return new String[0];

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[S.length()];
        traceback(S.toCharArray(), sb, visited);
        return res.toArray(new String[S.length()]);
    }

    private void traceback(char[] chars, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (visited[i]) continue;

            sb.append(String.valueOf(c));
            visited[i] = true;

            traceback(chars, sb, visited);

            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution0807().permutation("qwe")));
        System.out.println(Arrays.toString(new Solution0807().permutation("ab")));
    }
}