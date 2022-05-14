package com.longluo.leetcode.graph;

import java.util.Arrays;

/**
 * 743. 网络延迟时间
 * <p>
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * https://leetcode.cn/problems/network-delay-time/
 */
public class Problem743_networkDelayTime {

    // Dijkstra time: O(n^2 + m) space: O(n^2)
    public static int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE / 2;

        int[][] adjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjMat[i], INF);
        }

        for (int[] t : times) {
            int x = t[0] - 1;
            int y = t[1] - 1;
            adjMat[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        // 由于从 k 开始，所以该点距离设为 0，也即源点
        dist[k - 1] = 0;

        // 节点是否被更新数组
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            // 在还未确定最短路的点中，寻找距离最小的点
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }

            // 用该点更新所有其他点的距离
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + adjMat[x][y]);
            }
        }

        // 找到距离最远的点
        int ans = Arrays.stream(dist).max().getAsInt();

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
