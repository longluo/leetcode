package com.longluo.offer;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 限制：
 * 0 <= 树的结点个数 <= 10000
 * <p>
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class Offer55_balancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.right == null) {
            if (root.left.left != null || root.left.right != null) {
                return false;
            }
            return true;
        }

        if (root.right != null && root.left == null) {
            if (root.right.left != null || root.right.right != null) {
                return false;
            }
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static boolean isBalanced_dfs(TreeNode root) {
        if (root == null) {
            return true;
        }


        return false;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        return 0;
    }

    public static void main(String[] args) {
        TreeNode tstNode1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("true ?= " + isBalanced(tstNode1));

        TreeNode tstNode2 = TreeUtils.constructTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        System.out.println("false ?= " + isBalanced(tstNode2));
    }
}
