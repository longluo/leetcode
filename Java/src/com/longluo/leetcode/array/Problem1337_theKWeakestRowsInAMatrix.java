package com.longluo.leetcode.array;

import java.util.*;

/**
 * 1337. 矩阵中战斗力最弱的K行
 * <p>
 * 给你一个大小为m * n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * 示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 * 示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 * <p>
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class Problem1337_theKWeakestRowsInAMatrix {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int row = mat.length;
        int col = mat[0].length;

        List<int[]> count = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int value = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    value++;
                } else {
                    break;
                }
            }

            count.add(new int[]{i, value});
        }

        Collections.sort(count, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < k; i++) {
            ans[i] = count.get(i)[0];
        }

        return ans;
    }

    public static int[] kWeakestRows_sort(int[][] mat, int k) {
        int row = mat.length;
        int[][] cnt = new int[row][2];
        for (int i = 0; i < row; i++) {
            cnt[i][0] = i;
            cnt[i][1] = binaryCount(mat[i]);
        }

        Arrays.sort(cnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = cnt[i][0];
        }

        return ans;
    }

    public static int binaryCount(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(binaryCount(new int[]{1, 1, 0, 0, 0}));
        System.out.println(binaryCount(new int[]{1, 1, 1, 1, 0}));
    }
}
