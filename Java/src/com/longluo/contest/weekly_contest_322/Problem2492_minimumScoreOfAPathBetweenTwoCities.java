package com.longluo.contest.weekly_contest_322;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 */

/**
 * 2492. 两个城市间路径的最小分数
 * <p>
 * 给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，
 * 其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。
 * 城市构成的图不一定是连通的。
 * <p>
 * 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。
 * <p>
 * 城市 1 和城市 n 之间的所有路径的 最小 分数。
 * <p>
 * 注意：
 * 一条路径指的是两个城市之间的道路序列。
 * 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
 * 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
 * <p>
 * 示例 1：
 * 输入：n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * 输出：5
 * 解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
 * 不存在分数更小的路径。
 * <p>
 * 示例 2：
 * 输入：n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * 输出：2
 * 解释：城市 1 到城市 4 分数最小的路径是：1 -> 2 -> 1 -> 3 -> 4 。这条路径的分数是 min(2,2,4,7) = 2 。
 * <p>
 * 提示：
 * 2 <= n <= 10^5
 * 1 <= roads.length <= 10^5
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 10^4
 * 不会有重复的边。
 * 城市 1 和城市 n 之间至少有一条路径。
 * <p>
 * https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/
 */
public class Problem2492_minimumScoreOfAPathBetweenTwoCities {

    // Union Find time: O(n) space: O(n)
    public static int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : roads) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int[] edge : roads) {
            union(parents, edge[0], edge[1]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (find(parents, i) == 1 && graph[i].size() > 0) {
                graph[i].sort(Comparator.comparingInt(a -> a[1]));
                ans = Math.min(ans, graph[i].get(0)[1]);
            }
        }

        return ans;
    }

    private static int find(int[] parents, int x) {
        while (x != parents[x]) {
            x = parents[x];
            parents[x] = parents[parents[x]];
        }

        return x;
    }

    private static void union(int[] parents, int x, int y) {
        int rootX = find(parents, x);
        int rootY = find(parents, y);

        if (rootX <= rootY) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }

    // Union Find time: O(n) space: O(n)
    public static int minScore_uf(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n + 1);

        for (int[] edge : roads) {
            uf.unionFind(edge[0], edge[1]);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] edge : roads) {
            int u = edge[0];
            if (uf.isConnected(1, u) && edge[2] < ans) {
                ans = edge[2];
            }
        }

        return ans;
    }

    static class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
                parents[x] = parents[parents[x]];
            }

            return x;
        }

        void unionFind(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX <= rootY) {
                parents[rootY] = rootX;
            } else {
                parents[rootX] = rootY;
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // BFS time: O(n) space: O(n)
    public static int minScore_bfs(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph[u].add(new int[]{v, weight});
            graph[v].add(new int[]{u, weight});
        }

        int ans = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            List<int[]> neighbors = graph[curNode];
            for (int[] adj : neighbors) {
                ans = Math.min(ans, adj[1]);

                if (visited[adj[0]]) {
                    continue;
                }

                visited[adj[0]] = true;
                queue.offer(adj[0]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));
        System.out.println("1885 ?= " + minScore(6, new int[][]{{4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674}, {5, 6, 7852}, {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192}, {1, 3, 4065}, {1, 4, 7357}}));
        System.out.println("418 ?= " + minScore(36, new int[][]{{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569}, {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426}, {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910}, {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308}, {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251}, {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028}, {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030}, {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450}, {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533}, {14, 25, 6992}, {4, 20, 5831}}));

        System.out.println("2 ?= " + minScore_uf(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));

        System.out.println("5 ?= " + minScore_bfs(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
        System.out.println("418 ?= " + minScore_bfs(36, new int[][]{{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569}, {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426}, {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910}, {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308}, {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251}, {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028}, {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030}, {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450}, {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533}, {14, 25, 6992}, {4, 20, 5831}}));
    }
}
