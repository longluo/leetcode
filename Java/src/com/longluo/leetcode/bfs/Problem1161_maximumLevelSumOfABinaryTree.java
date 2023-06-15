package com.longluo.leetcode.bfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * <p>
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * 示例 1：
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * 示例 2：
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * 提示：
 * 树中的节点数在 [1, 10^4]范围内
 * -10^5 <= Node.val <= 10^5
 * <p>
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */
public class Problem1161_maximumLevelSumOfABinaryTree {

    // BFS time: O(n) space: O(n)
    public static int maxLevelSum_bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            if (sum > maxSum) {
                ans = level;
                maxSum = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 7, 0, 7, -8, null, null});
        System.out.println("2 ?= " + maxLevelSum_bfs(tst1));
    }
}
