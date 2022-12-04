package com.longluo.contest.weekly_contest_322;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 */
public class Problem3 {

    public static int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n + 1);

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            uf.union(u, v, weight);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (uf.isConnected(i, j) < Integer.MAX_VALUE) {
                        visited[j] = true;
                    }
                }
            }
        }

        return uf.isConnected(1, n);
    }

    static class UnionFind {
        int[] parent;
        int[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = Integer.MAX_VALUE;
            }
        }

        public void union(int x, int y, int value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                weight[rootX] = Math.min(value, weight[rootX]);
                weight[rootY] = Math.min(value, weight[rootY]);
                return;
            }

            parent[rootX] = rootY;
            weight[rootX] = Math.min(value, Math.min(weight[y], weight[x]));
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = Math.min(weight[x], weight[origin]);
            }

            return parent[x];
        }

        public int isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return Math.min(weight[x], weight[y]);
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));
        System.out.println("1885 ?= " + minScore(6, new int[][]{{4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674}, {5, 6, 7852}, {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192}, {1, 3, 4065}, {1, 4, 7357}}));
        System.out.println("418 ?= " + minScore(36, new int[][]{{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569}, {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426}, {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910}, {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308}, {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251}, {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028}, {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030}, {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450}, {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533}, {14, 25, 6992}, {4, 20, 5831}}));
    }
}
