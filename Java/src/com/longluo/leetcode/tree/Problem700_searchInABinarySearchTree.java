package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * 给定二叉搜索树:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * 和值: 2
 * <p>
 * 你应该返回如下子树:
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * <p>
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class Problem700_searchInABinarySearchTree {

    // Recursion time: O(n) space: O(1)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // BFS time: O(n) space: O(1)
    public TreeNode searchBST_bfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (val == node.val) {
                return node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return null;
    }

    // Iteration time: O(n) space: O(1)
    public TreeNode searchBST_iteration(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
