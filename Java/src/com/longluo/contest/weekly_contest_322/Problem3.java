package com.longluo.contest.weekly_contest_322;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 */

/**
 * https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/
 */
public class Problem3 {

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

        System.out.println("5 ?= " + minScore_bfs(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
        System.out.println("418 ?= " + minScore_bfs(36, new int[][]{{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569}, {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426}, {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910}, {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308}, {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251}, {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028}, {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030}, {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450}, {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533}, {14, 25, 6992}, {4, 20, 5831}}));
    }
}
