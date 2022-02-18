package com.longluo.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 1791. 找出星型图的中心节点
 * <p>
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，
 * 并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。
 * 请你找出并返回 edges 所表示星型图的中心节点。
 * <p>
 * 示例 1：
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 * <p>
 * 示例 2：
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 * <p>
 * 提示：
 * 3 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 题目数据给出的 edges 表示一个有效的星型图
 * <p>
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
public class Problem1791_findCenterOfStarGraph {

    public static int findCenter(int[][] edges) {
        int num = edges.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int[] edge = edges[i];
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int id = entry.getKey();
            int value = entry.getValue();
            if (value == num) {
                ans = id;
                return ans;
            }
        }

        return ans;
    }

    public static int findCenter_2(int[][] edges) {
        int n = edges.length + 1;
        int[] ids = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int[] edge = edges[i];
            ids[edge[0]]++;
            ids[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (ids[i] == n - 1) {
                return i;
            }
        }

        return 0;
    }

    public static int findCenter_3(int[][] edges) {
        int[] id = new int[2];
        id[0] = edges[0][0];
        id[1] = edges[0][1];
        for (int i = 0; i < 2; i++) {
            int idTemp = id[i];
            if (idTemp == edges[1][0] || idTemp == edges[1][1]) {
                return idTemp;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
