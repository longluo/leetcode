package com.longluo.contest.weekly_contest_307;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/
 */
public class Problem3 {

    public static int amountOfTime(TreeNode root, int start) {
        if (root != null && root.left == null && root.right == null) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        bfs(root, graph);

        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                List<Integer> neighbors = graph.get(cur);
                for (int v : neighbors) {
                    if (visited.contains(v)) {
                        continue;
                    }

                    visited.add(v);
                    queue.offer(v);
                }
            }

            time++;
        }

        return time - 1;
    }

    private static void bfs(TreeNode root, Map<Integer, List<Integer>> graph) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            int value = curNode.val;
            graph.putIfAbsent(value, new ArrayList<>());

            if (curNode.left != null) {
                int leftVal = curNode.left.val;

                graph.get(value).add(leftVal);
                graph.putIfAbsent(leftVal, new ArrayList<>());
                graph.get(leftVal).add(value);

                queue.offer(curNode.left);
            }

            if (curNode.right != null) {
                int rightVal = curNode.right.val;

                graph.get(value).add(rightVal);
                graph.putIfAbsent(rightVal, new ArrayList<>());
                graph.get(rightVal).add(value);
                queue.offer(curNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2});
        System.out.println("4 ?= " + amountOfTime(tst1, 3));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("0 ?= " + amountOfTime(tst2, 1));
    }
}
