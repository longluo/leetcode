package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * 树中的节点数在范围[0, 5000]内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Problem110_balancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("true ?= " + isBalanced(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        System.out.println("false ?= " + isBalanced(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{});
        System.out.println("true ?= " + isBalanced(tst3));
    }
}
