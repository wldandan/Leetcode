package com.wl.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        int[] counts = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i]-'A']++;
        }

        int[] sortedCounts = Arrays.stream(counts)
                .boxed()
        		.sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
        		.mapToInt(Integer::intValue)
        		.toArray();

        //总共有多少行
        int maxLine = counts[0];
//        for (Integer count: counts) {
//            maxLine = Integer.max(maxLine, count);
//        }

        /*
        * 最后一行有几个任务
        * 最后一行后面没有任务,不存在间隔
        * */

        int maxCount = 0;
        for (Integer count: counts) {
            if (count == maxLine) maxCount++;
        }
        return Math.max((n+1)*(maxLine - 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution621().leastInterval(new char[]{'A','A','A','B','B','B'},2));
        System.out.println(new Solution621().leastInterval(new char[]{'A','A','A','B'},2));
    }
}
