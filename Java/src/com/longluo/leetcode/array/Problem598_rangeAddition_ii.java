package com.longluo.leetcode.array;

/**
 * 598. 范围求和 II
 * <p>
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，
 * 其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>
 * 示例 2:
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * <p>
 * 提示:
 * 1 <= m, n <= 4 * 10^4
 * 0 <= ops.length <= 10^4
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 * <p>
 * https://leetcode-cn.com/problems/range-addition-ii/
 */
public class Problem598_rangeAddition_ii {

    // BF time: O(m^2 * n^2) space: O(m*n)
    // TimeOut
    public static int maxCount_bf(int m, int n, int[][] ops) {
        int[][] mat = new int[m][n];
        for (int[] op : ops) {
            int x = op[0];
            int y = op[1];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    mat[i][j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == mat[0][0]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Itersections time: O(k) space: O(1)
    public static int maxCount(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;
        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }

        return minA * minB;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + maxCount_bf(3, 3, new int[][]{{2, 2}, {3, 3}}));
        System.out.println("4 ?= " + maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
