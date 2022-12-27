package com.longluo.leetcode.Tree;

import java.util.*;

/**
 * 834. 树中距离之和
 * <p>
 * 给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
 * <p>
 * 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
 * <p>
 * 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
 * <p>
 * 示例 1:
 * 输入: n = 6, edges = [[0,1}, {0,2}, {2,3}, {2,4}, {2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释: 树如图所示。
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * <p>
 * 示例 2:
 * 输入: n = 1, edges = []
 * 输出: [0]
 * <p>
 * 示例 3:
 * 输入: n = 2, edges = [[1,0]]
 * 输出: [1,1]
 * <p>
 * 提示:
 * 1 <= n <= 3 * 10^4
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 给定的输入保证为有效的树
 * <p>
 * https://leetcode.cn/problems/sum-of-distances-in-tree/
 */
public class Problem834_sumOfDistancesInTree {

    // BF + DFS time: O(n) space: O(n)
    // TLE
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += bfs(graph, n, i, j);
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    private static int bfs(List<Integer>[] graph, int nodes, int source, int dest) {
        boolean[] visited = new boolean[nodes];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                List<Integer> neighbors = graph[curNode];
                for (int adj : neighbors) {
                    if (adj == dest) {
                        return level;
                    }

                    if (visited[adj]) {
                        continue;
                    }

                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println("[8, 12, 6, 10, 10, 10] ?= " + Arrays.toString(sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }
}
