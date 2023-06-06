package com.longluo.contest.weekly_contest_303;

import java.util.*;

/**
 * 2352. 相等行列对
 * <p>
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * 输入：grid = [[3,2,1}, {1,7,6}, {2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * <p>
 * 示例 2：
 * 输入：grid = [[3,1,2,2}, {1,4,4,5}, {2,4,2,2}, {2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * 提示：
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 10^5
 * <p>
 * https://leetcode.cn/problems/equal-row-and-column-pairs/
 */
public class Problem2352_equalRowAndColumnPairs {

    // BF time: O(n^3) space: O(1)
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        if (n <= 1) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Hash time: O(n^2) space: O(n)
    public static int equalPairs_hash(int[][] grid) {
        int n = grid.length;
        if (n <= 1) {
            return 1;
        }

        Map<Integer, String> rows = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }

            sb.deleteCharAt(sb.length() - 1);
            rows.put(i, sb.toString());
        }

        Map<String, Integer> cols = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append(",");
            }

            sb.deleteCharAt(sb.length() - 1);
            cols.put(sb.toString(), cols.getOrDefault(sb.toString(), 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            String s = rows.get(i);
            ans += cols.getOrDefault(s, 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));

        System.out.println("1 ?= " + equalPairs_hash(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println("3 ?= " + equalPairs_hash(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
        System.out.println("3 ?= " + equalPairs_hash(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}}));
    }
}
