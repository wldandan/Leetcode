package com.wl.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String root = files[0];
            for (int i = 1; i < files.length; i++) {
                String file = files[i];
                String fileName = file.substring(0, file.indexOf("("));
                String fileContent = file.substring(file.indexOf("("),file.length()-1);

                List<String> list = map.getOrDefault(fileContent, new ArrayList<>());
                list.add(root+"/"+fileName);
                map.put(fileContent, list);
            }
        }

        map.values().forEach(x -> {if (x.size()>1) res.add(x);});
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(
//            new Solution609().findDuplicate(
//                new String[]{"root/a 1.txt(abcd) 2.txt(efgh)",
//                        "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));

        System.out.println(
                new Solution609().findDuplicate(
                        new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"}));

    }
}