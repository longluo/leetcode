package com.longluo.leetcode.stack;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Problem114_flattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        preOrder(root, nodeList);
        int n = nodeList.size();
        for (int i = 1; i < n; i++) {
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

    public static void main(String[] args) {

    }
}
