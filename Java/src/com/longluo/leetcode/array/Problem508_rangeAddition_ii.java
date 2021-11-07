package com.longluo.leetcode.array;

/**
 * 598. 范围求和 II
 * <p>
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，
 * 含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>
 * 注意:
 * m 和 n 的范围是 [1,40000]。
 * a 的范围是 [1,m]，b 的范围是 [1,n]。
 * 操作数目不超过 10000。
 * <p>
 * https://leetcode-cn.com/problems/range-addition-ii/
 */
public class Problem508_rangeAddition_ii {

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0 || ops[0].length == 0) {
            return m * n;
        }

        int ans = 0;
        int[][] mat = new int[m][n];
        for (int[] op : ops) {
            int row = op[0];
            int col = op[1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j]++;
                }
            }
        }

        int maxVal = mat[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxVal == mat[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int maxCount_fast(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
        System.out.println("4 ?= " + maxCount_fast(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
