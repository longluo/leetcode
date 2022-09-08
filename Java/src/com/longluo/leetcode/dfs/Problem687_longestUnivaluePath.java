package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 687. 最长同值路径
 * <p>
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * 示例 1:
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * <p>
 * 示例 2:
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * <p>
 * 提示:
 * 树的节点数的范围是 [0, 10^4]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 * <p>
 * https://leetcode.cn/problems/longest-univalue-path/
 */
public class Problem687_longestUnivaluePath {

    // DFS time: O(n) space: O(n)
    static int maxAns = 1;

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxAns = 0;
        dfs(root);
        return maxAns;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.val == root.left.val) {
            left++;
            maxAns = Math.max(maxAns, left);
        } else {
            left = 0;
        }

        if (root.right != null && root.val == root.right.val) {
            right++;
            maxAns = Math.max(maxAns, right);
        } else {
            right = 0;
        }

        if (root.left != null && root.right != null && root.val == root.right.val && root.val == root.left.val) {
            maxAns = Math.max(maxAns, left + right);
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 4, 5, 1, 1, 5});
        System.out.println("2 ?= " + longestUnivaluePath(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 4, 5, 4, 4, null, 5});
        System.out.println("2 ?= " + longestUnivaluePath(tst2));
    }
}
