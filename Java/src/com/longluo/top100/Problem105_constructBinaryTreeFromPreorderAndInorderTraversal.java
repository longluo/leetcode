package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 * <p>
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * <p>
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Problem105_constructBinaryTreeFromPreorderAndInorderTraversal {

    // Recursion time: O(n) space: O(n)
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode buildTreeHelper(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int rootVal = preOrder[pStart];
        TreeNode root = new TreeNode(rootVal);

        int i_root_idx = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inOrder[i] == rootVal) {
                i_root_idx = i;
                break;
            }
        }

        int left = i_root_idx - iStart;

        root.left = buildTreeHelper(preOrder, pStart + 1, pStart + left + 1, inOrder, iStart, i_root_idx);
        root.right = buildTreeHelper(preOrder, pStart + left + 1, pEnd, inOrder, i_root_idx + 1, iEnd);

        return root;
    }

    // TODO: 2022/6/29  

    public static void main(String[] args) {
        // [-1]
        TreeUtils.printTree(buildTree(new int[]{-1}, new int[]{-1}));
        // [3,9,20,null,null,15,7]
        TreeUtils.printTree(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
