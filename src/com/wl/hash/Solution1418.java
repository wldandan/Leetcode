package com.wl.hash;

import java.util.*;

class Solution1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        for(List<String> order : orders) {
            String foodName = order.get(2);
            foodSet.add(foodName);
            String tableName = order.get(1);
            Map<String, Integer> m = map.getOrDefault(tableName, new HashMap<>());
            m.put(foodName, m.getOrDefault(foodName,0)+1);
            map.put(tableName,m);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList();

        header.addAll(foodSet);
        Collections.sort(header);
        header.add(0,"Table");
//        res.add(header);

        for (Map.Entry<String, Map<String, Integer>> entry: map.entrySet()) {
            ArrayList<String> tableAndOrder = new ArrayList<>();
            tableAndOrder.add(entry.getKey());

            for(String foodName:header.subList(1,header.size())) {
                tableAndOrder.add(String.valueOf(entry.getValue().getOrDefault(foodName,0)));
            }
            res.add(tableAndOrder);
        }
        Collections.sort(res, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return Integer.valueOf(o1.get(0)) - Integer.valueOf((o2.get(0)));
            }
        });
        res.add(0, header);
        return res;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase3() {
        ArrayList list = new ArrayList();
        list.add(Arrays.asList(new String[]{"Laura","2","Bean Burrito"}));
        list.add(Arrays.asList(new String[]{"Jhon","2","Beef Burrito"}));
        list.add(Arrays.asList(new String[]{"Melissa","2","Soda"}));
        System.out.println(new Solution1418().displayTable(list));
    }

    private static void testCase2() {
        ArrayList list = new ArrayList();
        list.add(Arrays.asList(new String[]{"James","12","Fried Chicken"}));
        list.add(Arrays.asList(new String[]{"Ratesh","12","Fried Chicken"}));
        list.add(Arrays.asList(new String[]{"Amadeus","12","Fried Chicken"}));
        list.add(Arrays.asList(new String[]{"Adam","1","Canadian Waffles"}));
        list.add(Arrays.asList(new String[]{"Brianna","1","Canadian Waffles"}));
        System.out.println(new Solution1418().displayTable(list));
    }

    private static void testCase1() {
        ArrayList list = new ArrayList();
        list.add(Arrays.asList(new String[]{"David","3","Ceviche"}));
        list.add(Arrays.asList(new String[]{"Corina","10","Beef Burrito"}));
        list.add(Arrays.asList(new String[]{"David","3","Fried Chicken"}));
        list.add(Arrays.asList(new String[]{"Carla","5","Water"}));
        list.add(Arrays.asList(new String[]{"Carla","5","Ceviche"}));
        list.add(Arrays.asList(new String[]{"Rous","3","Ceviche"}));
        System.out.println(new Solution1418().displayTable(list));
    }
}