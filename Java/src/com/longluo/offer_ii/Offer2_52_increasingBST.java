package com.longluo.offer_ii;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * <p>
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
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
 * <p>
 * 注意：本题与主站 897 题相同： https://leetcode.cn/problems/increasing-order-search-tree/
 * <p>
 * https://leetcode.cn/problems/NYBBNL/
 */
public class Offer2_52_increasingBST {

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversalInOrder(root, list);
        TreeNode newRootNode = new TreeNode(list.get(0));
        TreeNode pNode = newRootNode;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = new TreeNode(list.get(i));
            newRootNode.right = node;
            newRootNode = node;
        }
        return pNode;
    }

    public static void traversalInOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversalInOrder(root.left, list);
        list.add(root.val);
        traversalInOrder(root.right, list);
    }

    public static void main(String[] args) {

    }
}
