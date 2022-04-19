package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * 提示：
 * 树中节点数目范围是 [1, 3 * 10^4]
 * -1000 <= Node.val <= 1000
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class Problem124_binaryTreeMaximumPathSum {

    // DFS time: O(n) space: O(n)
    static int maxAns = Integer.MIN_VALUE;

    public static int maxPathSum_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return maxAns;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int sum = left + right + root.val;
        maxAns = Math.max(maxAns, sum);
        return Math.max(left, right);
    }

    // Recursion time: O(n) space: O(n)
    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int sum = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum, sum);
        return Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3});
        System.out.println("6 ?= " + maxPathSum(tst1));
        System.out.println("6 ?= " + maxPathSum_dfs(tst1));
    }
}
