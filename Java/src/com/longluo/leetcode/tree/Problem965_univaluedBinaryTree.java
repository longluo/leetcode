package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 965. 单值二叉树
 * <p>
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * <p>
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
public class Problem965_univaluedBinaryTree {

    // BFS time: O(n) space: O(n)
    public static boolean isUnivalTree_bfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int value = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != value) {
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return true;
    }

    // DFS time: O(n) space: O(n)
    public static boolean isUnivalTree_dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        return dfs(root.left, val) && dfs(root.right, val);
    }

    public static boolean dfs(TreeNode root, int value) {
        if (root == null) {
            return true;
        }

        if (root.val != value) {
            return false;
        }

        return dfs(root.left, value) && dfs(root.right, value);
    }

    // Recursion time: O(n) space: O(n)
    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right == null) {
            return root.val == root.left.val && isUnivalTree(root.left);
        }

        if (root.right != null && root.left == null) {
            return root.val == root.right.val && isUnivalTree(root.right);
        }

        return root.val == root.left.val && root.val == root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 1, 1, 1, 1, null, 1});
        System.out.println("true ?= " + isUnivalTree_dfs(tst1));
        System.out.println("true ?= " + isUnivalTree_bfs(tst1));
        System.out.println("true ?= " + isUnivalTree(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{2, 2, 2, 5, 2});
        System.out.println("false ?= " + isUnivalTree_dfs(tst2));
        System.out.println("false ?= " + isUnivalTree_bfs(tst2));
        System.out.println("false ?= " + isUnivalTree(tst2));
    }
}
