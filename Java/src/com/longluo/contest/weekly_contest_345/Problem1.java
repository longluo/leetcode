package com.longluo.contest.weekly_contest_345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-345
 */
public class Problem1 {

    public static int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];

        int prev = 1;

        for (int i = 0; ; i++) {
            int idx = prev + i * k;

            if (visited[(idx - 1) % n]) {
                break;
            }

            prev = idx;

            visited[(prev - 1) % n] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res.add(i);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[4, 5] ?= " + Arrays.toString(circularGameLosers(5, 2)));
        System.out.println("[2, 3, 4] ?= " + Arrays.toString(circularGameLosers(4, 4)));
    }
}
