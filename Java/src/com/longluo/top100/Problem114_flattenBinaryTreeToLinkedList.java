package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * <p>
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Problem114_flattenBinaryTreeToLinkedList {

    // PreOrder + DFS time: O(n) space: O(n)
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        preOrder(root, nodeList);
        int len = nodeList.size();
        for (int i = 1; i < len; i++) {
            TreeNode preNode = nodeList.get(i - 1);
            TreeNode currNode = nodeList.get(i);
            preNode.left = null;
            preNode.right = currNode;
        }
    }

    public static void preOrder(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        nodeList.add(root);
        preOrder(root.left, nodeList);
        preOrder(root.right, nodeList);
    }

    // PreOrder Iteration Stack + List time: O(n) space: O(n)
    public static void flatten_stack(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.empty()) {
            while (root != null) {
                nodeList.add(root);
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            root = root.right;
        }

        int len = nodeList.size();
        for (int i = 1; i < len; i++) {
            TreeNode preNode = nodeList.get(i - 1);
            TreeNode currNode = nodeList.get(i);
            preNode.left = null;
            preNode.right = currNode;
        }
    }

    // Recursion time: O(n) space: O(n)
    public static void flatten_rec(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten_rec(root.left);
        flatten_rec(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        // find the rightest node.
        while (root.right != null) {
            root = root.right;
        }

        root.right = temp;
    }

    // Recursion time: O(n) space: O(n)
    // TODO: 2022/5/9 Not Understand
    public static void flatten_iter(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    // https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten(tst1);
        flatten_stack(tst1);
        flatten_rec(tst1);
        flatten_iter(tst1);
    }
}
