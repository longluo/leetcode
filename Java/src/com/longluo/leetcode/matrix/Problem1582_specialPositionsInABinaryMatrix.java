package com.longluo.leetcode.matrix;

/**
 * 1582. Special Positions in a Binary Matrix
 * <p>
 * Easy
 * <p>
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 * <p>
 * Example 1:
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * <p>
 * Example 2:
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 * <p>
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 * <p>
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class Problem1582_specialPositionsInABinaryMatrix {

    // Simulate time: O(m^2 * n^2) space: O(1)
    public static int numSpecial(int[][] mat) {
        int ans = 0;

        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (k != j && mat[i][k] == 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int k = 0; k < m; k++) {
                        if (k != i && mat[k][j] == 1) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }
}
