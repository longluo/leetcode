package com.longluo.top100;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Problem101_symmetricTree {

    // BFS time: O(n) space: O(n)
    public static boolean isSymmetric_bfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null && node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!checkSymmetric(list)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkSymmetric(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }

        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (list.get(i) != list.get(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // Recursion time: O(n) space: O(n)
    public static boolean isSymmetric_rec(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
