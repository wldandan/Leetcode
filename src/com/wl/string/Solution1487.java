package com.wl.string;

import java.util.*;

class Solution1487 {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            if (map.containsKey(name)) {
                int count = map.get(name) + 1;
                String fileName = name + "(" + count + ")";

                while(map.containsKey(fileName)) {
                    count++;
                    fileName = name + "(" + count + ")";
                }
                res[index] = fileName;
                map.put(fileName, 0);
                map.put(name, count);
            }
            else {
                res[index] = name;
                map.put(name, 0);
            }
            index++;
        }
        return res;
    }


    public String[] getFolderNames2(String[] names) {
        List<String> list = new LinkedList<>();
        for (String name : names) {
            int count = 1;
            if (!list.contains(name)) {
                list.add(name);
            }
            else {
                String newName = name + "(" + count + ")";
                while(list.contains(newName)) {
                    count++;
                    newName = name + "(" + count + ")";
                }
                list.add(newName);
            }
        }
        return list.toArray(new String[names.length]);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                    new Solution1487().getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"})));
        System.out.println(
                Arrays.toString(
                    new Solution1487().getFolderNames(new String[]{"gta","gta(1)","gta","avalon"})));

        System.out.println(
                Arrays.toString(
                    new Solution1487().getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"})));
        System.out.println(
                Arrays.toString(
                    new Solution1487().getFolderNames(new String[]{"wano","wano","wano","wano"})));
        System.out.println(
                Arrays.toString(
                    new Solution1487().getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"})));
    }


}