package com.longluo.LCCUP.LCCUP_2020_Spring_Personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LCP 07. 传递信息
 * <p>
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * <p>
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，
 * 但 B 不能向 A 传信息）。
 * <p>
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * <p>
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
 * 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * 输入：n = 5, relation = [[0,2}, {2,1}, {3,4}, {2,3}, {1,4}, {2,0}, {0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，
 * 分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * 输入：n = 3, relation = [[0,2}, {2,1]], k = 2
 * 输出：0
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * <p>
 * https://leetcode.cn/problems/chuan-di-xin-xi/
 */
public class T2_LCP07_numWays {

    // BFS time: O(n) space: O(n)
    public static int numWays(int n, int[][] relation, int k) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : relation) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }

        int ans = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();

                if (k == 0 && curNode == n - 1) {
                    ans++;
                }

                List<Integer> nextNodes = graph[curNode];
                for (int node : nextNodes) {
                    queue.offer(node);
                }
            }

            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println("0 ?= " + numWays(3, new int[][]{{0, 2}, {2, 1}}, 2));
    }
}
