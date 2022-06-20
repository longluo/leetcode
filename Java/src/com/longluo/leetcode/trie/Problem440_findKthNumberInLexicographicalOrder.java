package com.longluo.leetcode.trie;

import java.util.Arrays;
import java.util.Comparator;

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
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
 */
public class Problem440_findKthNumberInLexicographicalOrder {

    // BF time: O(nlogn) space: O(n)
    public static int findKthNumber_str(int n, int k) {
        if (n == 1) {
            return 1;
        }

        String[] numStrs = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            numStrs[i] = "" + i;
        }

        Arrays.sort(numStrs);

        return Integer.parseInt(numStrs[k]);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findKthNumber_str(1, 1));
        System.out.println("10 ?= " + findKthNumber_str(13, 2));
    }
}
