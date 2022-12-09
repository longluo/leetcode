package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 1026. 节点与其祖先之间的最大差值
 * <p>
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 示例 1：
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 10^5
 * <p>
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 */
public class Problem1026_maxAncestorDiff {

    // 2 DFS time: O(n) space: O(n)
    static int max = 0;

    public static int maxAncestorDiff_bf(TreeNode root) {
        traversal(root);
        return max;
    }

    private static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root, root.val);

        traversal(root.left);
        traversal(root.right);
    }

    private static void dfs(TreeNode root, int ancestor) {
        if (root == null) {
            return;
        }

        max = Math.max(max, Math.abs(ancestor - root.val));

        dfs(root.left, ancestor);
        dfs(root.right, ancestor);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 2, null, 0, 3});
        System.out.println("3 ?= " + maxAncestorDiff_bf(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        System.out.println("7 ?= " + maxAncestorDiff_bf(tst2));
    }
}
