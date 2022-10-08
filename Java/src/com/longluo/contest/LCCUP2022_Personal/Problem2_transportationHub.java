package com.longluo.contest.LCCUP2022_Personal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LCP 62. 交通枢纽
 * <p>
 * 为了缓解「力扣嘉年华」期间的人流压力，组委会在活动期间开设了一些交通专线。
 * path[i] = [a, b] 表示有一条从地点 a通往地点 b 的 单向 交通专线。
 * <p>
 * 若存在一个地点，满足以下要求，我们则称之为 交通枢纽：
 * <p>
 * 所有地点（除自身外）均有一条 单向 专线 直接 通往该地点；
 * 该地点不存在任何 通往其他地点 的单向专线。
 * 请返回交通专线的 交通枢纽。若不存在，则返回 -1。
 * <p>
 * 注意：
 * 对于任意一个地点，至少被一条专线连通。
 * <p>
 * 示例 1：
 * 输入：path = [[0,1],[0,3],[1,3],[2,0],[2,3]]
 * 输出：3
 * <p>
 * 解释：如下图所示：
 * 地点 0,1,2 各有一条通往地点 3 的交通专线，
 * 且地点 3 不存在任何通往其他地点的交通专线。
 * <p>
 * 示例 2：
 * 输入：path = [[0,3],[1,0],[1,3],[2,0],[3,0],[3,2]]
 * 输出：-1
 * <p>
 * 解释：如下图所示：不存在满足 交通枢纽 的地点。
 * <p>
 * 提示：
 * 1 <= path.length <= 1000
 * 0 <= path[i][0], path[i][1] <= 1000
 * path[i][0] 与 path[i][1] 不相等
 * <p>
 * https://leetcode.cn/problems/D9PW8w/
 */
public class Problem2_transportationHub {

    // Graph time: O(n) space: O(n)
    public static int transportationHub(int[][] path) {
        Map<Integer, Integer> inDegreesMap = new HashMap<>();
        Map<Integer, Integer> outDegreesMap = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int[] edge : path) {
            int from = edge[0];
            int to = edge[1];

            set.add(from);
            set.add(to);

            inDegreesMap.put(to, inDegreesMap.getOrDefault(to, 0) + 1);
            outDegreesMap.put(from, outDegreesMap.getOrDefault(from, 0) + 1);
        }

        int nodeNum = set.size();
        for (Map.Entry<Integer, Integer> entry : inDegreesMap.entrySet()) {
            int node = entry.getKey();
            int indegrees = entry.getValue();
            if (indegrees == nodeNum - 1 && !outDegreesMap.containsKey(node)) {
                return node;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + transportationHub(new int[][]{{0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}}));
    }
}
