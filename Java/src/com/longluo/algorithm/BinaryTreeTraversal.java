package com.longluo.algorithm;

import com.longluo.datastructure.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * The Binary Tree Traversal
 * <p>
 * PreOrder, InOrder, PostOrder
 */
public class BinaryTreeTraversal {

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public void preOrder_iter(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.empty()) {
            while (root != null) {
                list.add(root.val);
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            root = root.right;
        }
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public void inOrder_iter(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.empty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public void postOrder_iter(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stk.empty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stk.push(root);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
