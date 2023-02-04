package com.longluo.contest.biweekly_contest_97;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-97
 */
public class Problem2 {

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int x : banned) {
            bannedSet.add(x);
        }

        int ans = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }

            if (sum + i <= maxSum) {
                ans++;
                sum += i;
            } else {
                break;
            }
        }

        return ans;
    }

    public static int maxCount_opt(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int x : banned) {
            set.add(x);
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }

            if (maxSum - i >= 0) {
                ans++;
                maxSum -= i;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maxCount(new int[]{1, 6, 5}, 5, 6));
        System.out.println("0 ?= " + maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
        System.out.println("0 ?= " + maxCount_opt(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
    }
}
