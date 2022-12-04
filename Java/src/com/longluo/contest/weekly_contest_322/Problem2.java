package com.longluo.contest.weekly_contest_322;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 */

public class Problem2 {

    public static long dividePlayers(int[] skill) {
        int len = skill.length;

        long sum = 0;
        for (int x : skill) {
            sum += x;
        }

        int teams = len / 2;
        if (sum % teams != 0) {
            return -1;
        }

        Arrays.sort(skill);

        long target = sum / teams;

        int left = 0;
        int right = len - 1;

        long ans = 0;
        while (left < right) {
            if (skill[left] + skill[right] != target) {
                return -1;
            }

            ans += (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return ans;
    }

    public static long dividePlayers_opt(int[] skill) {
        int n = skill.length;

        long sum = Arrays.stream(skill).sum();
        if (sum * 2 % n != 0) {
            return -1;
        }

        Arrays.sort(skill);
        long target = sum * 2 / n;

        long ans = 0;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if ((long) skill[i] + skill[j] != target) {
                return -1;
            }

            ans += (long) skill[i] * skill[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + dividePlayers(new int[]{10, 14, 16, 15, 9, 4, 4, 4}));
        System.out.println("12 ?= " + dividePlayers(new int[]{3, 4}));
        System.out.println("-1 ?= " + dividePlayers(new int[]{1, 1, 2, 3}));
        System.out.println("22 ?= " + dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }
}
