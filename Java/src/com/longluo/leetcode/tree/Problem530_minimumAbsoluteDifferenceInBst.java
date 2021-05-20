package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * 示例：
 * 输入：
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class Problem530_minimumAbsoluteDifferenceInBst {

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);
        for (int i = 0; i < numsList.size() - 1; i++) {
            ans = Math.min(ans, numsList.get(i + 1) - numsList.get(i));
        }

        return ans;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    static int ans;
    static int prev;

    public static int getMinimumDifference_2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = -1;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (prev >= 0) {
            ans = Math.min(ans, root.val - prev);
            prev = root.val;
        } else {
            prev = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 3, 2, null});
        System.out.println("1 ?= " + getMinimumDifference(tst1));
        System.out.println("1 ?= " + getMinimumDifference_2(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, null, 2});
        System.out.println("1 ?= " + getMinimumDifference(tst2));
        System.out.println("1 ?= " + getMinimumDifference_2(tst2));
    }
}
