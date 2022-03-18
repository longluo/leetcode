package com.longluo.leetcode.array;

import java.util.*;

/**
 * 599. Minimum Index Sum of Two Lists
 * Easy
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 * <p>
 * Example 1:
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * <p>
 * Example 2:
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * <p>
 * Constraints:
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the stings of list1 are unique.
 * All the stings of list2 are unique.
 * <p>
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
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
        System.out.println("Shogun ?= " + Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
