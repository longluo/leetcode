package com.longluo.contest.biweekly_contest_102;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/contest/biweekly-contest-102
 */
public class Problem3 {

    public static TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode pNode = root;

        int level = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pNode);

        while (!queue.isEmpty()) {
            level++;

            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);

                if (level < 3) {
                    node.val = 0;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    sum += node.left.val;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    sum += node.right.val;
                }
            }

            for (TreeNode node : levelNodes) {
                if (node.left != null && node.right != null) {
                    int val = sum - node.left.val - node.right.val;
                    node.left.val = val;
                    node.right.val = val;
                } else if (node.left != null) {
                    node.left.val = sum - node.left.val;
                } else if (node.right != null) {
                    node.right.val = sum - node.right.val;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 4, 9, 1, 10, null, 7});
        TreeUtils.printTree(replaceValueInTree(tst1));
    }
}
