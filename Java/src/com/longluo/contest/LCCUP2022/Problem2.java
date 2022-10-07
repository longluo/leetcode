package com.longluo.contest.LCCUP2022;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

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
