package com.longluo.leetcode.Graph;

import java.util.*;

/**
 * 2246. 相邻字符不同的最长路径
 * <p>
 * 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。
 * 用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，
 * 所以 parent[0] == -1 。
 * <p>
 * 另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
 * <p>
 * 请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
 * <p>
 * 示例 1：
 * 输入：parent = [-1,0,0,1,1,2], s = "abacbe"
 * 输出：3
 * 解释：任意一对相邻节点字符都不同的最长路径是：0 -> 1 -> 3 。该路径的长度是 3 ，所以返回 3 。
 * 可以证明不存在满足上述条件且比 3 更长的路径。
 * <p>
 * 示例 2：
 * 输入：parent = [-1,0,0,0], s = "aabc"
 * 输出：3
 * 解释：任意一对相邻节点字符都不同的最长路径是：2 -> 0 -> 3 。该路径的长度为 3 ，所以返回 3 。
 * <p>
 * 提示：
 * n == parent.length == s.length
 * 1 <= n <= 10^5
 * 对所有 i >= 1 ，0 <= parent[i] <= n - 1 均成立
 * parent[0] == -1
 * parent 表示一棵有效的树
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
 */
public class Problem2246_longestPathWithDifferentAdjacentCharacters {

    // DFS time: O(n^2) space: O(n)
    // TLE
    public static int longestPath(int[] parent, String s) {
        int n = parent.length;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int father = parent[i];
            graph.computeIfAbsent(father, value -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(graph, i, s));
        }

        return ans;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int node, String labels) {
        if (!graph.containsKey(node)) {
            return 1;
        }

        List<Integer> paths = new ArrayList<>();

        List<Integer> children = graph.get(node);
        for (int child : children) {
            if (labels.charAt(child) == labels.charAt(node)) {
                continue;
            }

            int childPath = dfs(graph, child, labels);
            paths.add(childPath);
        }

        Collections.sort(paths);

        int ans = 1;
        if (paths.size() > 0) {
            ans += paths.get(paths.size() - 1);
        }

        if (paths.size() > 1) {
            ans += paths.get(paths.size() - 2);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
    }
}
