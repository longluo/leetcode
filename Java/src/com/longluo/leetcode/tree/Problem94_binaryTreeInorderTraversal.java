package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Problem94_binaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    }

    public static List<Integer> inorderTraversal_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 2, 3});
        System.out.println("[1,3,2] ?= " + inorderTraversal(tst1).toString());
        System.out.println("[1,3,2] ?= " + inorderTraversal_iter(tst1).toString());

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{});
        System.out.println("[] ?= " + inorderTraversal(tst2).toString());
        System.out.println("[] ?= " + inorderTraversal_iter(tst2).toString());

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("[1] ?= " + inorderTraversal(tst3).toString());
        System.out.println("[1] ?= " + inorderTraversal_iter(tst3).toString());

        TreeNode tst4 = TreeUtils.constructTree(new Integer[]{1, 2});
        System.out.println("[2, 1] ?= " + inorderTraversal(tst4).toString());
        System.out.println("[2, 1] ?= " + inorderTraversal_iter(tst4).toString());

        TreeNode tst5 = TreeUtils.constructTree(new Integer[]{1, null, 2});
        System.out.println("[1, 2] ?= " + inorderTraversal(tst5).toString());
        System.out.println("[1, 2] ?= " + inorderTraversal_iter(tst5).toString());
    }
}
