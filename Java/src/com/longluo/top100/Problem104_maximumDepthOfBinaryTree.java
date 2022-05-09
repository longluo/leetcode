package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Problem104_maximumDepthOfBinaryTree {

    // Recursive time: O(n) space: O(n)
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    // DFS time: O(n) space: O(n)
    public static int maxDepth_dfs(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    // BFS time: O(n) space: O(n)
    public static int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans++;
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

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("3 ?= " + maxDepth(tst1));
        System.out.println("3 ?= " + maxDepth_dfs(tst1));
        System.out.println("3 ?= " + maxDepth_bfs(tst1));
    }
}
