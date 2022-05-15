package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 572. 另一个树的子树
 * <p>
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * <p>
 * 给定的树 t：
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * <p>
 * 给定的树 t：
 * 4
 * / \
 * 1   2
 * 返回 false。
 * <p>
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Problem572_subtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public static boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (checkSame(s, t)) {
            return true;
        }

        boolean left = dfs(s.left, t);
        boolean right = dfs(s.right, t);
        return left || right;
    }

    public static boolean checkSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }

        return checkSame(s.left, t.left) && checkSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{4, 1, 2});
        System.out.println("true ?= " + isSubtree(tst1, tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode tst4 = TreeUtils.constructTree(new Integer[]{4, 1, 2});
        System.out.println("false ?= " + isSubtree(tst3, tst4));
    }
}
