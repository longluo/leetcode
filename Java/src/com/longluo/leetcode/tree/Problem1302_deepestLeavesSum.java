package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * <p>
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * <p>
 * 示例 2：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/deepest-leaves-sum/
 */
public class Problem1302_deepestLeavesSum {

    // BFS time: O(n) space: O(n)
    public static int deepestLeavesSum_bfs(TreeNode root) {
        if (root == null) {
            return root.val;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            boolean isDeepest = true;
            sum = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    sum += curNode.val;
                }
                if (curNode.left != null) {
                    isDeepest = false;
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    isDeepest = false;
                    queue.offer(curNode.right);
                }
            }

            if (isDeepest && queue.isEmpty()) {
                return sum;
            }
        }

        return sum;
    }

    // DFS time: O(n) space: O(maxHeight)
    public static int deepestLeavesSum_dfs(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return dfs(root, 1, maxDepth);
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    public static int dfs(TreeNode root, int curDepth, int maxDepth) {
        if (root == null) {
            return 0;
        }

        if (curDepth == maxDepth) {
            return root.val;
        }

        int left = dfs(root.left, curDepth + 1, maxDepth);
        int right = dfs(root.right, curDepth + 1, maxDepth);

        return left + right;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        System.out.println("15 ?= " + deepestLeavesSum_bfs(tst1));
        System.out.println("15 ?= " + deepestLeavesSum_dfs(tst1));
    }
}
