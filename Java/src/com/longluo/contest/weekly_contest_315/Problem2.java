package com.longluo.contest.weekly_contest_315;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

    public static int countDistinctIntegers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int x : nums) {
            res.add(x);
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            int rev = Integer.parseInt(sb.reverse().toString());
            res.add(rev);
        }

        Set<Integer> set = new HashSet<>();
        for (int x : res) {
            set.add(x);
        }

        return set.size();
    }

    public static int countDistinctIntegers_opt(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            String revert = reverseString(String.valueOf(nums[i]));
            set.add(Integer.parseInt(revert));
        }

        return set.size();
    }

    private static String reverseString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
        System.out.println("6 ?= " + countDistinctIntegers_opt(new int[]{1, 13, 10, 12, 31}));
    }
}
