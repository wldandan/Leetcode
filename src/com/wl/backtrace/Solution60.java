package com.wl.backtrace;

import java.util.ArrayList;
import java.util.List;

class Solution60 {

    String res;
    List<String> resList = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    int count = 0;
    boolean[] visited;

    public String getPermutation(int n, int k) {
        visited = new boolean[n+1];

        backtrace(n, k, sb);

        return res;
    }

    private void backtrace(int n, int k, StringBuffer sb) {
        if (sb.length() == n){
            resList.add(sb.toString());
            count++;

            if (count == k) {
                res = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            sb.append(i);
            visited[i] = true;

            backtrace(n, k, sb);

            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution60 s = new Solution60();
        s.getPermutation(3,3);
        System.out.println(s.resList);
        System.out.println(s.res);

        s = new Solution60();
        s.getPermutation(4,9);
        System.out.println(s.resList);
        System.out.println(s.res);
    }
}