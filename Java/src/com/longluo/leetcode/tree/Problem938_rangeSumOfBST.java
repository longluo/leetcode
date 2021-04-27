package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中节点数目在范围[1, 2 * 10^4]内
 * 1 <= Node.val <= 10^5
 * 1 <= low <= high <= 10^5
 * 所有Node.val互不相同
 */
public class Problem938_rangeSumOfBST {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if (node.left != null && node.val >= low) {
                queue.offer(node.left);
            }

            if (node.right != null && node.val <= high) {
                queue.offer(node.right);
            }
        }

        return sum;
    }

    public static int rangeSumBST_rec(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val > high) {
            return rangeSumBST_rec(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSumBST_rec(root.right, low, high);
        }

        return root.val + rangeSumBST_rec(root.left, low, high) + rangeSumBST_rec(root.right, low, high);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        System.out.println("32 ?= " + rangeSumBST(tst1, 7, 15));
        System.out.println("32 ?= " + rangeSumBST_rec(tst1, 7, 15));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6});
        System.out.println("23 ?= " + rangeSumBST(tst2, 6, 10));
        System.out.println("23 ?= " + rangeSumBST_rec(tst2, 6, 10));
    }
}
