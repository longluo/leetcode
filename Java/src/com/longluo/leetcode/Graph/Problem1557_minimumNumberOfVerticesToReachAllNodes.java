package com.longluo.leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1557. 可以到达所有点的最少点数目
 * <p>
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，
 * 其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 * <p>
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 * <p>
 * 你可以以任意顺序返回这些节点编号。
 * <p>
 * 示例 1：
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * <p>
 * 示例 2：
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 * <p>
 * 提示：
 * 2 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi < n
 * 所有点对 (fromi, toi) 互不相同。
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class Problem1557_minimumNumberOfVerticesToReachAllNodes {

    // Indegree Count time: O(n) space: O(n)
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegrees = new int[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);

            indegrees[to]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> tst1 = new ArrayList<>();

        tst1.add(new ArrayList<>(Arrays.asList(0, 1)));
        tst1.add(new ArrayList<>(Arrays.asList(0, 2)));
        tst1.add(new ArrayList<>(Arrays.asList(2, 5)));
        tst1.add(new ArrayList<>(Arrays.asList(3, 4)));
        tst1.add(new ArrayList<>(Arrays.asList(4, 2)));

        System.out.println("[0, 3] ?= " + findSmallestSetOfVertices(6, tst1));
    }
}
