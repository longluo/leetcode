package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * 提示：
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Problem98_validateBinarySearchTree {

    // Recursion time: O(n) space: O(n)
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }

        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }

        return isValidBST(root.left, lowerBound, root.val) && isValidBST(root.right, root.val, upperBound);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 1, 3});
        System.out.println("true ?= " + isValidBST(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println("false ?= " + isValidBST(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println("false ?= " + isValidBST(tst3));
    }
}
