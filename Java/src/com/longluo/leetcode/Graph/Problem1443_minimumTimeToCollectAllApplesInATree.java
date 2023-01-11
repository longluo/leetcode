package com.longluo.leetcode.Graph;

import java.util.*;

/**
 * 1443. 收集树上所有苹果的最少时间
 * <p>
 * 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。
 * 你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * <p>
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。
 * 除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 * <p>
 * 示例 1：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * 输出：8
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * <p>
 * 示例 2：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * 输出：6
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * <p>
 * 示例 3：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * edges.length == n-1
 * edges[i].length == 2
 * 0 <= fromi, toi <= n-1
 * fromi < toi
 * hasApple.length == n
 * <p>
 * https://leetcode.cn/problems/minimum-time-to-collect-all-apples-in-a-tree/
 */
public class Problem1443_minimumTimeToCollectAllApplesInATree {

    static int ans = 0;

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] reverseEdges = new int[n];
        Arrays.fill(reverseEdges, -1);

        buildReverseEdges(graph, reverseEdges, 0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        for (int i = 1; i < n; i++) {
            if (graph.containsKey(i) && hasApple.get(i)) {
                dfs(reverseEdges, visited, i);
            }
        }

        return ans * 2;
    }

    public static void buildReverseEdges(Map<Integer, List<Integer>> graph, int[] reverseEdges, int from) {
        for (int pairNode : graph.get(from)) {
            if (pairNode != 0 && reverseEdges[pairNode] == -1) {
                reverseEdges[pairNode] = from;
                buildReverseEdges(graph, reverseEdges, pairNode);
            }
        }
    }

    public static void dfs(int[] reverseEdges, boolean[] visited, int to) {
        if (!visited[to]) {
            visited[to] = true;
            ans++;
            dfs(reverseEdges, visited, reverseEdges[to]);
        }
    }

    public static void main(String[] args) {

    }
}
