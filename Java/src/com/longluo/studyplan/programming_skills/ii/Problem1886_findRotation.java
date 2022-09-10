package com.longluo.studyplan.programming_skills.ii;

/**
 * 1886. Determine Whether Matrix Can Be Obtained By Rotation
 * <p>
 * Easy
 * <p>
 * Given two n x n binary matrices mat and target,
 * return true if it is possible to make mat equal to target by rotating mat in 90-degree increments,
 * or false otherwise.
 * <p>
 * Example 1:
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 * <p>
 * Example 2:
 * Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * Output: false
 * Explanation: It is impossible to make mat equal to target by rotating mat.
 * <p>
 * Example 3:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 * <p>
 * Constraints:
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] and target[i][j] are either 0 or 1.
 * <p>
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */
public class Problem1886_findRotation {

    // TODO: 2022/9/10  
    //
    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < 4; i++) {

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));
    }
}
