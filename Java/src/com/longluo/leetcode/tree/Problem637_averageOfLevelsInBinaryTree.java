package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * 输入：
 *   3
 *  / \
 * 9  20
 *   / \
 *  15  7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class Problem637_averageOfLevelsInBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(sum / size);
        }

        return ans;
    }

    public static List<Double> averageOfLevels_dfs(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, sums, counts);
        for (int i = 0; i < sums.size(); i++) {
            averages.add((double) sums.get(i) / counts.get(i));
        }

        return averages;
    }

    public static void dfs(TreeNode root, int level, List<Double> sums, List<Integer> counts) {
        if (root == null) {
            return;
        }

        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add((double) root.val);
            counts.add(1);
        }

        dfs(root.left, level + 1, sums, counts);
        dfs(root.right, level + 1, sums, counts);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("[3, 14.5, 11] ?= " + averageOfLevels(tst1));
        System.out.println("[3, 14.5, 11] ?= " + averageOfLevels_dfs(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{2147483647, 2147483647, 2147483647});
        System.out.println("[2147483647.0,2147483647.0] ?= " + averageOfLevels(tst2));
        System.out.println("[2147483647.0,2147483647.0] ?= " + averageOfLevels_dfs(tst2));
    }
}
