package com.wl.hash;

import com.sun.codemodel.internal.JForEach;

import java.util.HashMap;
import java.util.Map;

class Solution781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i],0)+1);
        }

        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            //场景1：key值大于value，个数就为key+1
            if (key > value) {
                res += key + 1;
            }
            else {
                //场景2：key值小于value，并且value是（key+1）的倍数
               if (value % (key+1) == 0 ){
                   res += value;
               }
               //场景3：key值小于value，并且value不是（key+1）的倍数
               else {
                   res += (value/(key+1)+1) * (key+1);
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution781().numRabbits(new int[]{1,1,2}));
        System.out.println(new Solution781().numRabbits(new int[]{10,10,10}));
        System.out.println(new Solution781().numRabbits(new int[]{0,0,0,2,2}));
        System.out.println(new Solution781().numRabbits(new int[]{}));
    }
}