package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 967. Numbers With Same Consecutive Differences
 * <p>
 * Medium
 * <p>
 * Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
 * <p>
 * Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * <p>
 * Example 2:
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * <p>
 * Constraints:
 * 2 <= n <= 9
 * 0 <= k <= 9
 * <p>
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Problem967_numbersWithSameConsecutiveDifferences {

    public static int[] numsSameConsecDiff(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, n, k);

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                num = 10 * num + res.get(i).get(j);
            }

            ans[i] = num;
        }

        return ans;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int idx, int n, int k) {
        if (idx == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (path.size() == 0 && i == 0) {
                continue;
            }

            if (path.size() > 0 && Math.abs(i - path.get(path.size() - 1)) != k) {
                continue;
            }

            path.add(i);
            backtrack(res, path, idx + 1, n, k);
            path.remove(path.size() - 1);
        }
    }

    // BFS time: O(10nk) space: O(n)
    public static int[] numsSameConsecDiff_bfs(int n, int k) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {

            }
        }

        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                num = 10 * num + res.get(i)[j];
            }

            ans[i] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[181, 292, 707, 818, 929] ?= " + Arrays.toString(numsSameConsecDiff(3, 7)));
    }
}
