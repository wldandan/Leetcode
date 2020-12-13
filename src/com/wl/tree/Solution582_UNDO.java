package com.wl.tree;

import java.util.*;

class Solution582_UNDO {



    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> res = new ArrayList();

        if (ppid == null || ppid.isEmpty()) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            int key = ppid.get(i);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(pid.get(i));
        }


        res.addAll(map.get(kill));
        List<Integer> tmp = map.get(kill);
        while(tmp != null){
        }

        for (int i = 0; i < tmp.size(); i++) {
            kill = tmp.get(i);
            while(map.containsKey(kill)){
                res.addAll(map.get(kill));
            }
        }


        while (map.containsKey(kill)) {
        }
        res.add(0, kill);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution582_UNDO().killProcess(Arrays.asList(1, 3, 10, 5),Arrays.asList(3, 0, 5, 3),5));
        System.out.println(new Solution582_UNDO().killProcess(Arrays.asList(1),Arrays.asList(0),1));
    }
}