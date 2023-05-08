package com.longluo.LCCUP.LCCUP_2022_Fall_Team;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LCP 67. 装饰树
 * <p>
 * 力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
 * <p>
 * 完成装饰的二叉树根结点与 root 的根结点值相同
 * 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 * 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 * 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
 * <p>
 * 现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
 * <p>
 * 示例 1：
 * 输入：
 * root = [7,5,6]
 * 输出：[7,-1,-1,5,null,null,6]
 * 解释：如下图所示，
 * <p>
 * 示例 2：
 * 输入：
 * root = [3,1,7,3,8,null,4]
 * 输出：[3,-1,-1,1,null,null,7,-1,-1,null,-1,3,null,null,8,null,4]
 * 解释：如下图所示
 * <p>
 * 提示：
 * 0 <= root.Val <= 1000
 * root 节点数量范围为 [1, 10^5]
 * <p>
 * https://leetcode.cn/problems/KnLfVT/
 */
public class T2_LCP67_expandBinaryTree {

    // BFS time: O(n) space: O(n)
    public static TreeNode expandBinaryTree(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {
                    TreeNode left = curNode.left;
                    curNode.left = new TreeNode(-1);
                    curNode.left.left = left;
                    queue.offer(left);
                }

                if (curNode.right != null) {
                    TreeNode right = curNode.right;
                    curNode.right = new TreeNode(-1);
                    curNode.right.right = right;
                    queue.offer(right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{7, 5, 6});
        TreeUtils.printTree(tst1);
        TreeUtils.printTree(expandBinaryTree(tst1));
    }
}
