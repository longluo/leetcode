package com.longluo.algo200;

import com.longluo.datastructure.TreeNode;

/**
 * 156. 上下翻转二叉树
 * <p>
 * 给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。
 * <p>
 * 你可以按下面的步骤翻转一棵二叉树：
 * 原来的左子节点变成新的根节点
 * 原来的根节点变成新的右子节点
 * 原来的右子节点变成新的左子节点
 * <p>
 * 上面的步骤逐层进行。题目数据保证每个右节点都有一个同级节点（即共享同一父节点的左节点）且不存在子节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：[4,5,2,null,null,3,1]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 10] 内
 * 1 <= Node.val <= 10
 * 树中的每个右节点都有一个同级节点（即共享同一父节点的左节点）
 * 树中的每个右节点都没有子节点
 * <p>
 * https://leetcode.cn/problems/binary-tree-upside-down/
 */
public class Problem156_binaryTreeUpsideDown {

    public static TreeNode upsideDownBinaryTree(TreeNode root) {

        return null;
    }

    public static void main(String[] args) {

    }
}
