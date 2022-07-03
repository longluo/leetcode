package com.longluo.offer;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 提示：
 * 节点总数 <= 10000
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class Offer55_maxDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right == null) {
            return maxDepth(root.left) + 1;
        }

        if (root.right != null && root.left == null) {
            return maxDepth(root.right) + 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    public static int maxDepth_dfs(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        if (root.left != null && root.right == null) {
            return dfs(root.left, depth + 1);
        }

        if (root.right != null && root.left == null) {
            return dfs(root.right, depth + 1);
        }

        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode tstNode1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("3 ?= " + maxDepth(tstNode1));
        System.out.println("3 ?= " + maxDepth_bfs(tstNode1));
        System.out.println("3 ?= " + maxDepth_dfs(tstNode1));
    }
}
