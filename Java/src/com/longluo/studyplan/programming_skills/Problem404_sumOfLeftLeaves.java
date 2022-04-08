package com.longluo.studyplan.programming_skills;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * <p>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 * <p>
 * 提示:
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 * <p>
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class Problem404_sumOfLeftLeaves {

    // BFS time: O(n) space: O(n)
    public static int sumOfLeftLeaves_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left != null && node.left.left == null && node.left.right == null) {
                ans += node.left.val;
            }
        }

        return ans;
    }

    // Recursion time: O(n) space: O(n)
    public static int sumOfLeftLeaves_rec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }

        ans += sumOfLeftLeaves_rec(root.left);
        ans += sumOfLeftLeaves_rec(root.right);
        return ans;
    }

    // DFS time: O(n) space: O(n)
    public static int sumOfLeftLeaves_dfs(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root.left) + dfs(root.right) + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{-9, -3, 2, null, 4, 4, 0, -6, null, -5});
        System.out.println("-11 ?= " + sumOfLeftLeaves_bfs(tst1));
        System.out.println("-11 ?= " + sumOfLeftLeaves_dfs(tst1));
        System.out.println("-11 ?= " + sumOfLeftLeaves_rec(tst1));
    }
}
