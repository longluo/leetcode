package com.longluo.contest.weekly_contest_354;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-354
 */
public class Problem3 {

    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        int dom = nums.get(0);
        int freq = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value * 2 > n) {
                dom = key;
                freq = value;
                break;
            }
        }

        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dom) {
                count[i + 1] = count[i] + 1;
            } else {
                count[i + 1] = count[i];
            }
        }

        for (int i = 1; i < n; i++) {
            int left = count[i];
            if (left * 2 <= i) {
                continue;
            }

            int right = freq - count[i];
            int len = n - i;
            if (right * 2 > len) {
                return i - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<>();
        tst1.add(1);
        tst1.add(2);
        tst1.add(2);
        tst1.add(2);

        System.out.println("2 ?= " + minimumIndex(tst1));
    }
}
