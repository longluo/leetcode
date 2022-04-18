package com.longluo.contest.weekly_contest_289;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2245. 转角路径的乘积中最多能有几个尾随零
 * <p>
 * 给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。
 * 转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），
 * 而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；
 * 反之亦然。
 * 当然，同样不能访问之前已经访问过的单元格。
 * 一条路径的 乘积 定义为：路径上所有值的乘积。
 * 请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。
 * <p>
 * 注意：
 * 水平 移动是指向左或右移动。
 * 竖直 移动是指向上或下移动。
 * <p>
 * 示例 1：
 * 输入：grid = [[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]
 * 输出：3
 * 解释：左侧的图展示了一条有效的转角路径。
 * 其乘积为 15 * 20 * 6 * 1 * 10 = 18000 ，共计 3 个尾随零。
 * 可以证明在这条转角路径的乘积中尾随零数目最多。
 * <p>
 * 中间的图不是一条有效的转角路径，因为它有不止一个弯。
 * 右侧的图也不是一条有效的转角路径，因为它需要重复访问已经访问过的单元格。
 * <p>
 * 示例 2：
 * 输入：grid = [[4,3,2],[7,6,1],[8,8,8]]
 * 输出：0
 * 解释：网格如上图所示。
 * 不存在乘积含尾随零的转角路径。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= grid[i][j] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/maximum-trailing-zeros-in-a-cornered-path/
 */
public class Problem2245_maximumTrailingZerosInACorneredPath {

    // time: O(n^2) space: O(n^2)
    public static int maxTrailingZeros(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] rowCnts2 = new int[row + 1][col + 1];
        int[][] colCnts2 = new int[row + 1][col + 1];
        int[][] rowCnts5 = new int[row + 1][col + 1];
        int[][] colCnts5 = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int value = grid[i][j];
                int two = getFactor(value, 2);
                int five = getFactor(value, 5);
                rowCnts2[i][j] = rowCnts2[i][j - 1] + two;
                rowCnts5[i][j] = rowCnts5[i][j - 1] + five;

                colCnts2[i][j] = colCnts2[i - 1][j] + two;
                colCnts5[i][j] = colCnts5[i - 1][j] + five;
            }
        }

        int ans = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                ans = Math.max(ans, Math.min(rowCnts2[i][j] + colCnts2[i - 1][j],
                        rowCnts5[i][j] + colCnts5[i - 1][j]));
                ans = Math.max(ans, Math.min(rowCnts2[i][j] + colCnts2[row][j] - colCnts2[i][j],
                        rowCnts5[i][j] + colCnts5[row][j] - colCnts5[i][j]));
                // 从右边出发，到上边结束
                ans = Math.max(ans, Math.min(rowCnts2[i][col] - rowCnts2[i][j] + colCnts2[i][j],
                        rowCnts5[i][col] - rowCnts5[i][j] + colCnts5[i][j]));
                // 从右边出发，到下边结束
                ans = Math.max(ans, Math.min(rowCnts2[i][col] - rowCnts2[i][j] + colCnts2[row][j] - colCnts2[i - 1][j],
                        rowCnts5[i][col] - rowCnts5[i][j] + colCnts5[row][j] - colCnts5[i - 1][j]));
            }
        }

        return ans;
    }

    public static int getFactor(int num, int factor) {
        int ans = 0;
        while (num % factor == 0) {
            ans++;
            num /= factor;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
