package com.longluo.leetcode.array;

import java.util.*;

public class Problem599_minimumIndexSumOfTwoLists {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<Idx> res = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (map1.containsKey(str)) {
                res.add(new Idx(str, map1.get(str) + i));
            }
        }

        Collections.sort(res, new Comparator<Idx>() {
            @Override
            public int compare(Idx o1, Idx o2) {
                return o1.idx - o2.idx;
            }
        });

        int len = 1;
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).idx == res.get(0).idx) {
                len++;
            }
        }

        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            ans[i] = res.get(i).name;
        }

        return ans;
    }

    static class Idx {
        String name;
        int idx;

        Idx(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {

    }
}
