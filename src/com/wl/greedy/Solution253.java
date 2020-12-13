package com.wl.greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution253 {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1] ? o1[0]- o2[0] : o1[1]- o2[1];
            }
        });

        int res = 1;
        List<Integer> list = new ArrayList<>();

        int earliestEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= earliestEnd){
                earliestEnd = intervals[i][1];
                continue;
            }
            else
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution253().minMeetingRooms(new int[][]{{5,7},{6,20},{7,10},{8,11},{0,30}, {15,30}}));
//        System.out.println(new Solution253().minMeetingRooms(new int[][]{{7, 10},{2,4}}));
//        System.out.println(new Solution253().minMeetingRooms(new int[][]{{13, 15},{1,13}}));
//        System.out.println(new Solution253().minMeetingRooms(new int[][]{{2, 11},{6,16},{11,16}}));
        System.out.println(new Solution253().minMeetingRooms(new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}}));
    }
}