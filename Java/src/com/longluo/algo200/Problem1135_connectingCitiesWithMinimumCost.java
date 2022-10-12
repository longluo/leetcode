package com.longluo.algo200;

import java.util.*;

/**
 * 1135. 最低成本联通所有城市
 * <p>
 * 想象一下你是个城市基建规划者，地图上有 n 座城市，它们按以 1 到 n 的次序编号。
 * <p>
 * 给你整数 n 和一个数组 conections，其中 connections[i] = [xi, yi, costi] 表示将城市 xi 和城市 yi 连接所要的costi（连接是双向的）。
 * <p>
 * 返回连接所有城市的最低成本，每对城市之间至少有一条路径。如果无法连接所有 n 个城市，返回 -1
 * <p>
 * 该 最小成本 应该是所用全部连接成本的总和。
 * <p>
 * 示例 1：
 * 输入：n = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 * <p>
 * 示例 2：
 * 输入：n = 4, conections = [[1,2,3],[3,4,4]]
 * 输出：-1
 * 解释：即使连通所有的边，也无法连接所有城市。
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * 1 <= connections.length <= 10^4
 * connections[i].length == 3
 * 1 <= xi, yi <= n
 * xi != yi
 * 0 <= costi <= 10^5
 * <p>
 * https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
 */
public class Problem1135_connectingCitiesWithMinimumCost {

    // Prim time: O(nlogn) space: O(n)
    public static int minimumCost_prim(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{1, 0});

        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            if (visited.contains(curNode[0])) {
                continue;
            }

            visited.add(curNode[0]);
            ans += curNode[1];

            for (int[] neighbor : graph.get(curNode[0])) {
                pq.offer(neighbor);
            }
        }

        return visited.size() == n ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + minimumCost_prim(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        System.out.println("-1 ?= " + minimumCost_prim(4, new int[][]{{1, 2, 3}, {3, 4, 4}}));
    }
}
