package com.longluo.contest.biweekly_contest_108;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-108
 */
public class Problem2 {

    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> posMap = new HashMap<>();

        for (int x : nums) {
            posMap.put(x, posMap.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];

            if (from == to) {
                continue;
            }

            posMap.put(to, posMap.getOrDefault(to, 0) + posMap.get(from));
            posMap.remove(from);
        }

        List<Integer> ans = new ArrayList<>();

        for (int key : posMap.keySet()) {
            ans.add(key);
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1] ?= " + relocateMarbles(new int[]{3, 4}, new int[]{4, 3, 1, 2, 2, 3, 2, 4, 1}, new int[]{3, 1, 2, 2, 3, 2, 4, 1, 1}));
        System.out.println("[11, 20, 23] ?= " + relocateMarbles(new int[]{4, 6, 6, 9, 18}, new int[]{18, 6, 17, 4, 9, 19, 2}, new int[]{23, 17, 20, 19, 11, 2, 20}));
        System.out.println("[5, 6, 8, 9] ?= " + relocateMarbles(new int[]{1, 6, 7, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5}));
        System.out.println("[2] ?= " + relocateMarbles(new int[]{1, 1, 3, 3}, new int[]{1, 3}, new int[]{2, 2}));
    }
}
