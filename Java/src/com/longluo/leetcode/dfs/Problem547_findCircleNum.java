package com.longluo.leetcode.dfs;

/**
 * 547. 省份数量
 * <p>
 * 有n个城市，其中一些彼此相连，另一些没有相连。如果城市a与城市b直接相连，且城市b与城市c直接相连，
 * 那么城市a与城市c间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个n x n的矩阵isConnected，其中isConnected[i][j] = 1表示第i个城市和第j个城市直接相连，
 * 而isConnected[i][j] = 0表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * * 1 1 0
 * * 1 1 0
 * * 0 0 1
 * 输出：2
 *
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Problem547_findCircleNum {

    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
//        for (int i = 0; i < provinces; i++) {
//            if (!visited[i] && isConnected[i][]) {
//                dfs(isConnected, visited,  i);
//                circles++;
//            }
//        }

        return circles;
    }

    private static void dfs(int[][] isConnected, boolean[] isVisited) {
//        if () {
//
//        }
//
//        for (int j = 0; j < ) {
//
//        }
    }

    public static void main(String[] args) {

    }
}
