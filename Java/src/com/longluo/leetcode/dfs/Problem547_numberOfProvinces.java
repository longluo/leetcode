package com.longluo.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 547. 省份数量
 * <p>
 * 有n个城市，其中一些彼此相连，另一些没有相连。如果城市a与城市b直接相连，且城市b与城市c直接相连，
 * 那么城市a与城市c间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个n x n的矩阵isConnected，其中isConnected[i][j] = 1表示第i个城市和第j个城市直接相连，
 * 而isConnected[i][j] = 0表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0}, {1,1,0}, {0,0,1]]
 * * 1 1 0
 * * 1 1 0
 * * 0 0 1
 * 输出：2
 *
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0}, {0,1,0}, {0,0,1]]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * https://leetcode.cn/problems/number-of-provinces/
 */
public class Problem547_numberOfProvinces {

    // BFS time: O(n^2) space: O(n^2)
    public static int findCircleNum_bfs(int[][] isConnected) {
        int n = isConnected.length;

        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph[i].add(j);
                }
            }
        }

        int ans = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            bfs(graph, visited, i);
            ans++;
        }

        return ans;
    }

    private static void bfs(List<Integer>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            List<Integer> adjs = graph[curNode];
            for (int nextCity : adjs) {
                if (visited[nextCity]) {
                    continue;
                }

                visited[nextCity] = true;
                queue.offer(nextCity);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findCircleNum_bfs(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println("3 ?= " + findCircleNum_bfs(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
