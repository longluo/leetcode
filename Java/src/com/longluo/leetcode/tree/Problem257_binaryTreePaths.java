package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class Problem257_binaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, "", ans);
        return ans;
    }

    public static void dfs(TreeNode root, String str, List<String> list) {
        if (root == null) {
            return;
        }

        if (str.length() == 0) {
            str = root.val + "";
        } else {
            str = str + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            list.add(str);
            return;
        }

        dfs(root.left, str, list);
        dfs(root.right, str, list);
    }

    public static List<String> binaryTreePaths_bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }

        List<String> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> sum = new LinkedList<>();
        queue.offer(root);
        sum.add(root.val + "");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String str = sum.poll();
            if (node.left == null && node.right == null) {
                ans.add(str);
            }

            if (node.left != null) {
                queue.offer(node.left);
                String left = str + "->" + node.left.val;
                sum.offer(left);
            }

            if (node.right != null) {
                queue.offer(node.right);
                String right = str + "->" + node.right.val;
                sum.offer(right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 5});
        System.out.println("[1->2->5, 1->3] ?= " + binaryTreePaths(tst1).toString());
        System.out.println("[1->2->5, 1->3] ?= " + binaryTreePaths_bfs(tst1).toString());
    }
}
