package com.longluo.leetcode.MinimumSpanningTree;

import java.util.*;

/**
 * 1584. 连接所有点的最小费用
 * <p>
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * <p>
 * 示例 2：
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * <p>
 * 示例 3：
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * <p>
 * 示例 4：
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * <p>
 * 示例 5：
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= points.length <= 1000
 * -10^6 <= xi, yi <= 10^6
 * 所有点 (xi, yi) 两两不同。
 * <p>
 * https://leetcode.cn/problems/min-cost-to-connect-all-points/
 */
public class Problem1584_minCostToConnectAllPoints {

    // Prim time: O(n^2 + nlogn) space: O(n^2)
    public static int minCostConnectPoints_prim(int[][] points) {
        int len = points.length;

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < len; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < len; j++) {
                graph.putIfAbsent(j, new ArrayList<>());

                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                graph.get(i).add(new int[]{j, dist});
                graph.get(j).add(new int[]{i, dist});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        int minCost = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            if (visited.contains(curNode[0])) {
                continue;
            }

            visited.add(curNode[0]);
            minCost += curNode[1];

            List<int[]> neighbors = graph.get(curNode[0]);
            for (int[] adj : neighbors) {
                pq.offer(new int[]{adj[0], adj[1]});
            }
        }

        return minCost;
    }

    // Kruskal
    public static int minCostConnectPoints_kruskal(int[][] points) {
        int len = points.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(len);

        int minCost = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (uf.isConnected(u, v)) {
                continue;
            }

            uf.union(u, v);
            minCost += edge[2];
            if (uf.getCount() == 1) {
                break;
            }
        }

        return minCost;
    }

    static class UnionFind {
        int[] parents;
        int[] rank;
        int count;

        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            count = 0;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }

            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] < rank[rootY]) {
                parents[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parents[rootY] = rootX;
            } else {
                parents[rootY] = rootX;
                rank[rootX]++;
            }

            count--;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minCostConnectPoints_prim(new int[][]{{0}}));
        System.out.println("4 ?= " + minCostConnectPoints_prim(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println("4000000 ?= " + minCostConnectPoints_prim(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println("18 ?= " + minCostConnectPoints_prim(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));

        System.out.println("4000000 ?= " + minCostConnectPoints_kruskal(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println("18 ?= " + minCostConnectPoints_kruskal(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
    }
}
