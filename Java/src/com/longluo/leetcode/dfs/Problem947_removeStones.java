package com.longluo.leetcode.dfs;

import java.util.*;

/**
 * 947. 移除最多的同行或同列石头
 * <p>
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * 给你一个长度为 n 的数组 stones ，其中stones[i] = [xi, yi]表示第i块石头的位置，返回可以移除的石子的最大数量。
 * <p>
 * 示例 1：
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * <p>
 * 示例 2：
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * <p>
 * 示例 3：
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 * <p>
 * 提示：
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 10^4
 * 不会有两块石头放在同一个坐标点上
 * <p>
 * https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/
 */
public class Problem947_removeStones {

    // DFS time: O(n^2) space: O(n)
    public static int removeStones_dfs(int[][] stones) {
        int n = stones.length;
        if (n <= 1) {
            return 0;
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int[] u = stones[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] v = stones[j];
                if (u[0] == v[0] || u[1] == v[1]) {
                    graph[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(graph, visited, i);
            ans++;
        }

        return n - ans;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int start) {

        visited[start] = true;

        List<Integer> neighbors = graph[start];
        for (int x : neighbors) {
            if (visited[x]) {
                continue;
            }

            dfs(graph, visited, x);
        }
    }

    public static int removeStones_uf(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }

        return stones.length - unionFind.getCount();
    }

    static class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }

            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            count--;
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + removeStones_uf(new int[][]{{0, 0}}));
        System.out.println("5 ?= " + removeStones_uf(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println("3 ?= " + removeStones_uf(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));

        System.out.println("0 ?= " + removeStones_dfs(new int[][]{{0, 0}}));
        System.out.println("5 ?= " + removeStones_dfs(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println("3 ?= " + removeStones_dfs(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
    }
}
