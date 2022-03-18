package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * <p>
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Problem617_mergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static TreeNode mergeTrees_rec(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        if (root1 != null) {
            root1.val += root2.val;
            root1.left = mergeTrees_rec(root1.left, root2.left);
            root1.right = mergeTrees_rec(root1.right, root2.right);
        }

        return root1;
    }

    public static TreeNode mergeTrees_bfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left != null || node2.left != null) {
                if (node1.left != null && node2.left != null) {
                    TreeNode leftNode = new TreeNode(node1.left.val + node2.left.val);
                    node.left = leftNode;
                    queue.offer(leftNode);
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                } else if (node1.left != null) {
                    node.left = node1.left;
                } else if (node2.left != null) {
                    node.left = node2.left;
                }
            }

            if (node1.right != null || node2.right != null) {
                if (node1.right != null && node2.right != null) {
                    TreeNode rightNode = new TreeNode(node1.right.val + node2.right.val);
                    node.right = rightNode;
                    queue.offer(rightNode);
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                } else if (node1.right != null) {
                    node.right = node1.right;
                } else if (node2.right != null) {
                    node.right = node2.right;
                }
            }
        }

        return merged;
    }

    public static TreeNode mergeTrees_dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        dfs(root1, root2);
        return root1;
    }

    public static void dfs(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1 != root2) {
                root1.val += root2.val;
            }

            if (root1.left == null) {
                root1.left = root2.left;
            }
            if (root1.right == null) {
                root1.right = root2.right;
            }
            dfs(root1.left, root2.left);
            dfs(root1.right, root2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 3, 2, 5});
        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode result1 = mergeTrees(tst1, tst2);
        TreeNode result2 = mergeTrees_bfs(tst1, tst2);
        TreeNode result3 = mergeTrees_dfs(tst1, tst2);
        TreeUtils.printTree(result1);
        TreeUtils.printTree(result2);
        TreeUtils.printTree(result3);
    }
}
