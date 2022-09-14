package com.longluo.leetcode.trie;

import java.util.Arrays;

/**
 * 440. 字典序的第K小数字
 * <p>
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * 示例 1:
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * <p>
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: 1
 * <p>
 * 提示:
 * 1 <= k <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
 */
public class Problem440_findKthNumberInLexicographicalOrder {

    // BF time: O(nlogn) space: O(n)
    // Memory Out
    public static int findKthNumber_str(int n, int k) {
        String[] numStrs = new String[n];
        for (int i = 1; i <= n; i++) {
            numStrs[i - 1] = String.valueOf(i);
        }

        Arrays.sort(numStrs);

        return Integer.parseInt(numStrs[k - 1]);
    }

    // DFS
    // AC
    static int index = 0;
    static int ans = 0;

    public static int findKthNumber_dfs(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            int cnt = count(n, i, "");
            if (k > cnt + index) {
                index += cnt;
                continue;
            }

            if (dfs(n, k, "" + i)) {
                break;
            }
        }

        return ans;
    }

    private static boolean dfs(int n, int k, String cur) {
        index++;

        if (index == k) {
            ans = Integer.valueOf(cur);
            return true;
        }

        for (int i = 0; i <= 9; i++) {
            int cnt = count(n, i, cur);
            if (k > cnt + index) {
                index += cnt;
                continue;
            }

            if (Integer.valueOf(cur + i) <= n) {
                if (dfs(n, k, cur + i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int count(int n, int i, String prefix) {
        long cur = Long.valueOf(prefix + i);
        int res = 0;
        int start = 1;
        while (cur <= n) {
            res += start;
            cur *= 10;
            start *= 10;
        }

        if (n < (cur / 10 + start / 10 - 1)) {
            res -= cur / 10 + start / 10 - 1 - n;
        }

        return res;
    }

    //
    public static int findKthNumber(int n, int k) {
        k--;
        int prefix = 1;
        while (k > 0) {
            int cnt = prefixCount(prefix, n);
            if (k < cnt) {
                k--;
                prefix *= 10;
            } else {
                k -= cnt;
                prefix++;
            }
        }

        return prefix;
    }

    private static int prefixCount_bf(long prefix, int upperBound) {
        if (prefix > upperBound) {
            return 0;
        }

        int res = 1;
        for (int i = 0; i < 10; i++) {
            res += prefixCount_bf(10 * prefix + i, upperBound);
        }

        return res;
    }

    public static int prefixCount(long prefix, int n) {
        long mask = 1;

        while (prefix * mask <= n) {
            mask *= 10;
        }

        return prefixCount(prefix, mask / 10, n);
    }

    public static int prefixCount(long prefix, long mask, int upperBound) {
        if (prefix > upperBound) {
            return 0;
        }

        if (prefix != upperBound / mask) {
            return 1 + 10 * prefixCount(prefix * 10 + 0, mask / 10, upperBound);
        }

        int res = 1;
        for (int i = 0; i < 10; ++i) {
            res += prefixCount(prefix * 10 + i, mask / 10, upperBound);
        }

        return res;
    }

    public static int findKthNumber_ref(int n, int k) {
        int prefix = 1;
        k--;
        while (k > 0) {
            int steps = calSteps(n, prefix, prefix + 1);

            if (steps <= k) {
                prefix += 1;
                k -= steps;
            } else {
                prefix *= 10;
                k -= 1;
            }
        }

        return prefix;
    }

    //use long in case of overflow
    public static int calSteps(int n, long n1, long n2) {
        int steps = 0;

        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findKthNumber_str(1, 1));
        System.out.println("10 ?= " + findKthNumber_str(13, 2));

        System.out.println("19 ?= " + findKthNumber_str(25, 11));

        System.out.println("10 ?= " + findKthNumber_dfs(13, 2));

        System.out.println("10 ?= " + findKthNumber(13, 2));
        System.out.println("19 ?= " + findKthNumber(25, 11));
        System.out.println("21 ?= " + findKthNumber(25, 14));

        System.out.println("138377349 ?= " + findKthNumber(804289384, 42641503));

        System.out.println("138377349 ?= " + findKthNumber_ref(804289384, 42641503));
    }
}
