package com.longluo.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            numStrs[i - 1] = String.valueOf(i - 1);
        }

        Arrays.sort(numStrs);

        return Integer.parseInt(numStrs[k - 1]);
    }

    // PreOrder Tree
    public static int findKthNumber_tree(int n, int k) {


        return 0;
    }

    private static void buildTree(int n) {
        int idx = 1;

        Node root = new Node(0);
        for (int i = 1; i <= 9; i++) {

        }
    }

    static class Node {
        int idx;
        List<Node> children;

        public Node(int idx) {
            this.idx = idx;
            this.children = new ArrayList<>();
        }
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

    public static void main(String[] args) {
        System.out.println("1 ?= " + findKthNumber_str(1, 1));
        System.out.println("10 ?= " + findKthNumber_str(13, 2));

        System.out.println("10 ?= " + findKthNumber_dfs(13, 2));
    }
}
