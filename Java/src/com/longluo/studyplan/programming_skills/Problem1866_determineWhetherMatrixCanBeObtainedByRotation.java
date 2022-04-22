package com.longluo.studyplan.programming_skills;

/**
 * 1886. 判断矩阵经轮转后是否一致
 * <p>
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * <p>
 * 示例 2：
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * <p>
 * 示例 3：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * 提示：
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1
 * <p>
 * https://leetcode-cn.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */
public class Problem1866_determineWhetherMatrixCanBeObtainedByRotation {

    public static boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length;
        int[][] rotate = new int[len][len];
        for (int i = 0; i < 4; i++) {

        }

        return false;
    }

    public static boolean isEqual(int[][] mat, int[][] target) {
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
