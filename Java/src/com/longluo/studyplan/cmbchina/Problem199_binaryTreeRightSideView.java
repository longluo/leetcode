package com.longluo.studyplan.cmbchina;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * 输入: []
 * 输出: []
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 */
public class Problem199_binaryTreeRightSideView {

    // DFS time: O(n) space: O(n)
    public static List<Integer> rightSideView_dfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, 1, ans);
        return ans;
    }

    public static void dfs(TreeNode root, int depth, List<Integer> numList) {
        if (root == null) {
            return;
        }

        if (numList.size() < depth) {
            numList.add(root.val);
        }

        dfs(root.right, depth + 1, numList);
        dfs(root.left, depth + 1, numList);
    }

    // BFS time: O(n) space: O(n)
    public static List<Integer> rightSideView_bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ans.add(node.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println("[1, 3, 4] ?= " + rightSideView_dfs(tst1));
        System.out.println("[1, 3, 4] ?= " + rightSideView_bfs(tst1));
    }
}
