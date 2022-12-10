package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 1339. 分裂二叉树的最大乘积
 * <p>
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * <p>
 * 示例 3：
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * <p>
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/
 */
public class Problem1339_maximumProductofSplittedBinaryTree {

    // 2 DFS time: O(n) space: O(n)
    // TLE
    static long max = 0;

    public static int maxProduct(TreeNode root) {
        max = 0;

        int mod = 1_000_000_007;

        long sum = getSum(root);

        dfs(root, sum);

        return (int) (max % mod);
    }

    private static void dfs(TreeNode root, long sum) {
        if (root == null) {
            return;
        }

        long left = getSum(root.left);
        long right = getSum(root.right);

        max = Math.max(max, left * (sum - left));
        max = Math.max(max, right * (sum - right));

        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    private static long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 1});
        System.out.println("1 ?= " + maxProduct(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println("110 ?= " + maxProduct(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1, null, 2, 3, 4, null, null, 5, 6});
        System.out.println("90 ?= " + maxProduct(tst3));
    }
}
