package com.longluo.contest.weekly_contest_286;

import java.util.*;

public class Problem1 {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        for (int num : nums1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        List<Integer> one = new ArrayList<>(list1);
        List<Integer> two = new ArrayList<>(list2);
        ans.add(one);
        ans.add(two);

        return ans;
    }


    public static void main(String[] args) {
        findDifference(new int[]{1, 1, 3, 3}, new int[]{1, 1, 2, 2});
    }
}
