package com.wl.dfs;

import java.util.*;

class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.isEmpty()) return res;

        Map<String, LinkedList<String>> itineraryMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            LinkedList<String> dests = itineraryMap.getOrDefault(from, new LinkedList<>());
            dests.add(ticket.get(1));
            itineraryMap.put(from, dests);
        }

        buildItineray("JFK", itineraryMap, res);
        return res;
    }

    private void buildItineray(String from, Map<String, LinkedList<String>> itineraryMap, List<String> res) {
        res.add(from);

        LinkedList<String> values = itineraryMap.get(from);
        if ( values == null || values.size() == 0 ) return;

        Collections.sort(values);
        while(!values.isEmpty()) {
            String nextFrom = values.removeFirst();
            if (!values.isEmpty()) {
                itineraryMap.put(from, values);
            }
            buildItineray(nextFrom, itineraryMap, res);
        }
    }

    public static void main(String[] args) {
//        testCase1();
//        testCase2();
//        testCase3();
        testCase4();
    }

    private static void testCase1() {
        List<List<String>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList("MUC", "LHR"));
        inputs.add(Arrays.asList("JFK", "MUC"));
        inputs.add(Arrays.asList("SFO", "SJC"));
        inputs.add(Arrays.asList("LHR", "SFO"));
        System.out.println(new Solution332().findItinerary(inputs));
    }

    private static void testCase4() {
        List<List<String>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList("JFK", "KUL"));
        inputs.add(Arrays.asList("JFK", "NRT"));
        inputs.add(Arrays.asList("NRT", "JFK"));
        System.out.println(new Solution332().findItinerary(inputs));
    }

    private static void testCase2() {
        List<List<String>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList("JFK", "SFO"));
        inputs.add(Arrays.asList("JFK", "ATL"));
        inputs.add(Arrays.asList("SFO", "ATL"));
        inputs.add(Arrays.asList("ATL", "JFK"));
        inputs.add(Arrays.asList("ATL", "SFO"));
        System.out.println(new Solution332().findItinerary(inputs));
    }

    private static void testCase3() {
        List<List<String>> inputs = new ArrayList<>();
        System.out.println(new Solution332().findItinerary(inputs));
    }

}