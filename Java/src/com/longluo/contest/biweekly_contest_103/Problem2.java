package com.longluo.contest.biweekly_contest_103;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-103
 */
public class Problem2 {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] ans = new int[n];

        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; i++) {
            cnt[A[i]]++;
            cnt[B[i]]++;

            for (int k = 1; k <= n; k++) {
                if (cnt[k] == 2) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0, 2, 3, 4] ?= " + Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
    }
}
