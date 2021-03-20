package com.wl.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String dir = files[0];
            for (int i = 1; i < files.length; i++) {
                String fileWithContent = files[i];
                String fileName = fileWithContent.substring(0, fileWithContent.indexOf("("));
                String content = fileWithContent.substring(fileWithContent.indexOf("(")+1, fileWithContent.indexOf(")"));
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(dir+"/"+fileName);
                map.put(content, list);
            }
        }

        return map.values().stream().filter(x->x.size() > 1).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(
        new Solution609().findDuplicate(
                new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }
}