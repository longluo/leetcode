package com.longluo.leetcode.Graph;

import java.util.Arrays;

/**
 * 1129. 颜色交替的最短路径
 * <p>
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。
 * 类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。
 * 如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 * 示例 1：
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * <p>
 * 示例 2：
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * <p>
 * 示例 3：
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * <p>
 * 示例 4：
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * <p>
 * 示例 5：
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * <p>
 * 提示：
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * <p>
 * https://leetcode.cn/problems/shortest-path-with-alternating-colors/
 */
public class Problem1129_shortestPathWithAlternatingColors {

    // BFS 
    // TODO: 2023/2/11  
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];


        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0, 1, -1] ?= " + Arrays.toString(shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{{}})));
    }
}

