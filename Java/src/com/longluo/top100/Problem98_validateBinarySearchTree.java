package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

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
 * https://leetcode.com/problems/validate-binary-search-tree/
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

    // DFS time: O(n) space: O(n)
    public static boolean isValidBST_dfs(TreeNode root) {
        List<Integer> numList = new ArrayList<>();
        dfs(root, numList);
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) <= numList.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    // Iteration time: O(n) space: O(n)
    public static boolean isValidBST_iter(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        List<Integer> numList = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();

            if (numList.size() > 0 && root.val <= numList.get(numList.size() - 1)) {
                return false;
            }

            numList.add(root.val);
            root = root.right;
        }

        return true;
    }

    // Iteration Opt time: O(n) space: O(n)
    public static boolean isValidBST_iter_opt(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Deque<TreeNode> stk = new ArrayDeque<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 1, 3});
        System.out.println("true ?= " + isValidBST(tst1));
        System.out.println("true ?= " + isValidBST_dfs(tst1));
        System.out.println("true ?= " + isValidBST_iter(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println("false ?= " + isValidBST(tst2));
        System.out.println("false ?= " + isValidBST_dfs(tst2));
        System.out.println("false ?= " + isValidBST_iter(tst2));
        System.out.println("false ?= " + isValidBST_iter_opt(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println("false ?= " + isValidBST(tst3));
        System.out.println("false ?= " + isValidBST_dfs(tst3));
        System.out.println("false ?= " + isValidBST_iter(tst3));
    }
}
