package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 * <p>
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Problem112_pathSum {

    // DFS time: O(n) space: O(n)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    public static boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return  (root.left != null && dfs(root.left, targetSum - root.val))
                || (root.right != null && dfs(root.right, targetSum - root.val));
    }

    // Recursion time: O(n) space: O(n)
    public static boolean hasPathSum_rec(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum_rec(root.left, targetSum - root.val)
                || hasPathSum_rec(root.right, targetSum - root.val);
    }

    // BFS time: O(n) space: O(n)
    public static boolean hasPathSum_bfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> sum = new LinkedList<>();
        sum.offer(targetSum - root.val);
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                int value = sum.poll();
                if (node.left == null && node.right == null) {
                    if (value == 0) {
                        return true;
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    sum.offer(value - node.left.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    sum.offer(value - node.right.val);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1, 2});
        System.out.println("false ?= " + hasPathSum(tst3, 0));
        System.out.println("false ?= " + hasPathSum_rec(tst3, 0));
        System.out.println("false ?= " + hasPathSum_bfs(tst3, 0));

        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println("true ?= " + hasPathSum(tst1, 22));
        System.out.println("true ?= " + hasPathSum_rec(tst1, 22));
        System.out.println("true ?= " + hasPathSum_bfs(tst1, 22));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2, 3});
        System.out.println("false ?= " + hasPathSum(tst2, 5));
        System.out.println("false ?= " + hasPathSum_rec(tst2, 5));
        System.out.println("false ?= " + hasPathSum_bfs(tst2, 5));

        TreeNode tst4 = TreeUtils.constructTree(new Integer[]{});
        System.out.println("false ?= " + hasPathSum(tst4, 0));
        System.out.println("false ?= " + hasPathSum_rec(tst4, 0));
        System.out.println("false ?= " + hasPathSum_bfs(tst4, 0));
    }
}
