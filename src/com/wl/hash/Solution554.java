package com.wl.hash;

import java.util.*;

class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.isEmpty()) return 0;
        int layers = wall.size();
        int largestCutsNum = 0;
        List<Integer> item;
        Integer key = 0;
        Map<Integer, Integer> cuts = new HashMap<>();
        for (int i = 0; i < layers; i++) {
            item = wall.get(i);
            key = 0;
            for (int j = 0; j < item.size() - 1; j++) {
                Integer cut = item.get(j);
                key = key + cut.intValue();
                cuts.put(key, cuts.getOrDefault(key,0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : cuts.entrySet()) {
            largestCutsNum = Math.max(largestCutsNum, entry.getValue());
        }

        return layers - largestCutsNum;
    }

    public static void main(String[] args) {
//        List res = new ArrayList<>();
//        res.add(Arrays.asList(1,2,2,1));
//        res.add(Arrays.asList(3,1,2));
//        res.add(Arrays.asList(1,3,2));
//        res.add(Arrays.asList(2,4));
//        res.add(Arrays.asList(3,1,2));
//        res.add(Arrays.asList(1,3,1,1));

//        System.out.println(new Solution554().leastBricks(res));

        List res2 = new ArrayList<>();
        res2.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        res2.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        res2.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        System.out.println(new Solution554().leastBricks(res2));

    }
}