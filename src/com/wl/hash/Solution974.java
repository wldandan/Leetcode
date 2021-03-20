package com.wl.hash;

import java.util.HashMap;
import java.util.Map;

class Solution974 {
    public int subarraysDivByK(int[] A, int K) {
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int ele:A) {
            preSum += ele;
            int modulus = (preSum % K + K) % K;
            if (map.containsKey(modulus)) {
                count += map.get(modulus);
            }
            map.put(modulus, map.getOrDefault(modulus,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution974().subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}