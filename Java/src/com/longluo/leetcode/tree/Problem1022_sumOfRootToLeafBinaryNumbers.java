package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1022. 从根到叶的二进制数之和
 * <p>
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * 示例 1：
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * 示例 2：
 * 输入：root = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：3
 * <p>
 * 提示：
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 * <p>
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Problem1022_sumOfRootToLeafBinaryNumbers {

    public static int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        for (int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);
        }
        return sum;
    }

    public static void dfs(TreeNode root, int path, List<Integer> ans) {
        if (root == null) {
            return;
        }

        path = path << 1;
        path = path + root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
    }

    public static int sumRootToLeaf_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> paths = new LinkedList<>();
        queue.offer(root);
        paths.offer(root.val);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = paths.poll();
            if (node.left == null && node.right == null) {
                sum += value;
            }
            int temp = value << 1;
            if (node.left != null) {
                queue.offer(node.left);
                paths.offer(temp + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                paths.offer(temp + node.right.val);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        System.out.println("22 ?= " + sumRootToLeaf(tst1));
        System.out.println("22 ?= " + sumRootToLeaf_bfs(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{0});
        System.out.println("0 ?= " + sumRootToLeaf(tst2));
        System.out.println("0 ?= " + sumRootToLeaf_bfs(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("1 ?= " + sumRootToLeaf(tst3));
        System.out.println("1 ?= " + sumRootToLeaf_bfs(tst3));

        TreeNode tst4 = TreeUtils.constructTree(new Integer[]{1, 1});
        System.out.println("3 ?= " + sumRootToLeaf(tst4));
        System.out.println("3 ?= " + sumRootToLeaf_bfs(tst4));
    }
}
