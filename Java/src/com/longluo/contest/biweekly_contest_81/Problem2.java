package com.longluo.contest.biweekly_contest_81;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
public class Problem2 {

    // BF Graph
    // TLE
    public static long countPairs(int n, int[][] edges) {
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

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                boolean[] visited = new boolean[n];
                if (!dfs(graph, visited, i, j)) {
                    ans++;
                }
            }
        }

        return ans / 2;
    }

    private static boolean dfs(List<Integer>[] graph, boolean[] visited, int start, int end) {
        if (start == end) {
            return true;
        }

        visited[start] = true;

        boolean result = false;

        List<Integer> neighbors = graph[start];
        for (int v : neighbors) {
            if (visited[v]) {
                continue;
            }

            if (dfs(graph, visited, v, end)) {
                result = true;
                break;
            }
        }

        return result;
    }

    // UnionFind
    public static long countPairs_uf(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            uf.union(u, v);
        }

        int len = uf.grps;
        int[] grpNum = new int[len];
        for (int i = 0, j = 0; i < n && j < len; i++) {
            if (uf.getGrpSize(i) > 0) {
                grpNum[j] = uf.getGrpSize(i);
                j++;
            }
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            long cnt = grpNum[i];
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    ans += cnt * grpNum[j];
                }
            }
        }

        return ans / 2;
    }

    static class UnionFind {
        int[] parents;
        int[] count;
        int grps;

        UnionFind(int n) {
            grps = n;
            parents = new int[n];
            count = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                count[i] = 1;
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }

            return parents[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (count[rootX] > count[rootY]) {
                parents[rootY] = rootX;
                count[rootX] += count[rootY];
                count[rootY] = 0;
            } else {
                parents[rootX] = rootY;
                count[rootY] += count[rootX];
                count[rootX] = 0;
            }

            grps--;
        }

        int getGrpSize(int x) {
            return count[x];
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println("14 ?= " + countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));

        System.out.println("0 ?= " + countPairs_uf(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println("14 ?= " + countPairs_uf(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));
    }
}
