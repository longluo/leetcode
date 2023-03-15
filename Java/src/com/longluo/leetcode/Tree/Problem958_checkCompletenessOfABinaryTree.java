package com.longluo.leetcode.Tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. 二叉树的完全性检验
 * <p>
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * <p>
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。
 * 它可以包含 1 到 2h 节点之间的最后一级 h 。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * <p>
 * 提示：
 * 树的结点数在范围  [1, 100] 内。
 * 1 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 */
public class Problem958_checkCompletenessOfABinaryTree {

    // TODO: 2023/3/15  
    // BFS time: O(n) space: O(n)
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLast = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();

                if (curNode.right == null) {
                    isLast = true;
                }

                if (!isLast && (curNode.left == null || curNode.right == null)) {
                    return false;
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println("true ?= " + isCompleteTree(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        System.out.println("false ?= " + isCompleteTree(tst2));
    }
}
