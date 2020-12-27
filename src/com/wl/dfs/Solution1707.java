package com.wl.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*
* ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
* synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]

*
* */

class Solution1707 {

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> nameFrequencyMap = new HashMap<>();
        Map<String, String> nameUnionMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(0, names[i].indexOf("("));
            Integer frequency = Integer.valueOf(names[i].substring(names[i].indexOf("(")+1,names[i].indexOf(")")));
            nameFrequencyMap.put(name, frequency);
        }

        for (int i = 0; i < synonyms.length; i++) {
            int idx = synonyms[i].indexOf(',');
            String synonym = synonyms[i];
            String firstname = synonym.substring(1, idx);
            String lastname = synonym.substring(idx+1, synonym.length()-1);

            while (nameUnionMap.containsKey(firstname)) {
                firstname = nameUnionMap.get(firstname);
            }

            while (nameUnionMap.containsKey(lastname)) {
                lastname = nameUnionMap.get(lastname);
            }


            if (!firstname.equals(lastname)) {
                String rootName = firstname.compareTo(lastname) > 0 ? lastname : firstname;
                String nickName = firstname.compareTo(lastname) > 0 ? firstname : lastname;

                nameUnionMap.put(nickName, rootName);

                nameFrequencyMap.put(rootName, nameFrequencyMap.getOrDefault(rootName, 0)
                        + nameFrequencyMap.getOrDefault(nickName, 0));
                nameFrequencyMap.remove(nickName);
            }
        }

        String[] res = new String[nameFrequencyMap.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : nameFrequencyMap.entrySet()) {
            res[i++] = entry.getKey() + "(" + entry.getValue() + ")";
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution1707().trulyMostPopular(
                new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"},
                new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"})));
    }
}