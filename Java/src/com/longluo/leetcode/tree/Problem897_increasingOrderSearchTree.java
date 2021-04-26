package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 */
public class Problem897_increasingOrderSearchTree {

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode head = dummyNode;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            TreeNode temp = new TreeNode(value);
            head.right = temp;
            head = temp;
        }

        return dummyNode.right;
    }

    public static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
//        TreeUtils.printTree(increasingBST(tst1));
        TreeUtils.inOrderPrint(increasingBST(tst1));
    }
}
