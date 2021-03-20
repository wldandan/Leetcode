package com.wl.hash;

import javafx.util.Pair;

import java.util.*;

class Solution1722 {
    public String[] sortFeatures(String[] features, String[] responses) {
        String[] res = new String[features.length];

        Map<String, Integer> featureIdx = new HashMap<>();
        Map<String, Integer> featureFreq = new HashMap<>();

        for (int i = 0; i <features.length; i++) {
            featureIdx.put(features[i], i);
            featureFreq.put(features[i],0);
        }

        Map<String, Integer> responseMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <responses.length; i++) {
            String[] words = responses[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (featureIdx.containsKey(word) && !set.contains(word)) {
                    featureFreq.put(word, featureFreq.get(word)+1);
                    set.add(word);
                }
            }
            set.clear();
        }

        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getValue() == o2.getValue()?
                        featureIdx.get(o1.getKey()) - featureIdx.get(o2.getKey()) : o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : featureFreq.entrySet()) {
            queue.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(
                new Solution1722().sortFeatures(new String[]{"cooler","lock","touch"},
                    new String[]{"i like cooler cooler","lock touch cool","locker like touch"})));

        System.out.println(
                Arrays.toString(
                        new Solution1722().sortFeatures(new String[]{"a","aa","b","c"},
                                new String[]{"a","a aa","a a a a a","b a"})));
    }
}