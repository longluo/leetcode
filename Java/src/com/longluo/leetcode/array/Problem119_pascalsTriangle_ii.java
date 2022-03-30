package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class Problem119_pascalsTriangle_ii {

    // Use BF O(n^2) O(n^2)
    public static List<Integer> getRow_bf(int rowIndex) {
        List<List<Integer>> pascals = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pascals.get(i - 1).get(j - 1) + pascals.get(i - 1).get(j));
                }
            }

            pascals.add(row);
        }

        return pascals.get(rowIndex);
    }

    // Use DP O(n^2) O(n)
    public static List<Integer> getRow_dp(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = cur;
        }

        return pre;
    }

    // DP Opt O(n^2) O(1)
    public static List<Integer> getRow_dp_opt(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    // Math O(n) O(1)
    public static List<Integer> getRow_math(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {

    }
}
