package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Problem144_binaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        preOrder(root, ans);
        return ans;
    }

    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static List<Integer> preorderTraversal_iter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 2, 3});
        System.out.println("[1,2,3] ?= " + preorderTraversal(tst1));
        System.out.println("[1,2,3] ?= " + preorderTraversal_iter(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{});
        System.out.println("[] ?= " + preorderTraversal(tst2));
        System.out.println("[] ?= " + preorderTraversal_iter(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("[1] ?= " + preorderTraversal(tst3));
        System.out.println("[1] ?= " + preorderTraversal_iter(tst3));

        TreeNode tst4 = TreeUtils.constructTree(new Integer[]{1, 2});
        System.out.println("[1,2] ?= " + preorderTraversal(tst4));
        System.out.println("[1,2] ?= " + preorderTraversal_iter(tst4));

        TreeNode tst5 = TreeUtils.constructTree(new Integer[]{1, null, 2});
        System.out.println("[1,2] ?= " + preorderTraversal(tst5));
        System.out.println("[1,2] ?= " + preorderTraversal_iter(tst5));
    }
}
