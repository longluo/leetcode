package com.longluo.contest.biweekly_contest_102;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-102
 */
public class Problem4 {

    static class Graph {
        List<List<int[]>> graph;
        int nodeCnt;

        private void buildGraph(int[][] edges) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                List<int[]> adjs = graph.get(u);
                adjs.add(new int[]{v, w});
            }
        }

        public Graph(int n, int[][] edges) {
            this.nodeCnt = n;

            graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            buildGraph(edges);
        }

        public void addEdge(int[] edge) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            List<int[]> adjs = graph.get(u);
            adjs.add(new int[]{v, weight});
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
            pq.offer(new int[]{node1, 0});

            int[] dist = new int[nodeCnt];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[node1] = 0;

            boolean[] seen = new boolean[nodeCnt];

            while (!pq.isEmpty()) {
                int[] edge = pq.poll();

                int curNode = edge[0];
                int weight = edge[1];

                if (seen[curNode]) {
                    continue;
                }

                seen[curNode] = true;

                List<int[]> neighbors = graph.get(curNode);

                for (int[] adj : neighbors) {
                    int next = adj[0];
                    int cost = adj[1];

                    if (weight + cost < dist[next]) {
                        dist[next] = weight + cost;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }

            return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
        }
    }

    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */

    public static void main(String[] args) {

    }
}
