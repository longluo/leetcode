package com.longluo.contest.weekly_contest_343;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-343
 */
public class Problem2 {

    // TLE
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (m == 1 || n == 1) {
            return 0;
        }

        int min = Math.min(m, n);
        int max = Math.max(m, n);

        int sum = m * n;

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        boolean[][] marked = new boolean[m][n];

        for (int i = 0; i < sum; i++) {
            int[] loc = map.get(arr[i]);
            marked[loc[0]][loc[1]] = true;

            if (i >= (min - 1)) {
                if (check(marked)) {
                    return i;
                }
            }
        }

        return sum - 1;
    }

    private static boolean check(boolean[][] marked) {
        int m = marked.length;
        int n = marked[0].length;

        for (int i = 0; i < m; i++) {
            if (marked[i][0]) {
                boolean flag = true;
                for (int j = 1; j < n; j++) {
                    if (!marked[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (marked[0][i]) {
                boolean flag = true;
                for (int j = 1; j < m; j++) {
                    if (!marked[j][i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int firstCompleteIndex_map(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < m * n; i++) {
            idxMap.put(arr[i], i);
        }

        int ans = m * n - 1;

        for (int r = 0; r < m; r++) {
            int idx = idxMap.get(mat[r][0]);

            for (int c = 1; c < n; c++) {
                idx = Math.max(idx, idxMap.get(mat[r][c]));
            }

            ans = Math.min(ans, idx);
        }

        for (int c = 0; c < n; c++) {
            int idx = idxMap.get(mat[0][c]);
            for (int r = 1; r < m; r++) {
                idx = Math.max(idx, idxMap.get(mat[r][c]));
            }
            ans = Math.min(ans, idx);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + firstCompleteIndex(new int[]{1, 4, 5, 2, 6, 3}, new int[][]{{4, 3, 5}, {1, 2, 6}}));
        System.out.println("1 ?= " + firstCompleteIndex_map(new int[]{1, 4, 5, 2, 6, 3}, new int[][]{{4, 3, 5}, {1, 2, 6}}));
    }
}
