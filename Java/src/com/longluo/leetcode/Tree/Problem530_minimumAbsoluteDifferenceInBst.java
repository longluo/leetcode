package com.longluo.leetcode.Tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

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
 * 本题与 783 https://leetcode.cn/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 */
public class Problem530_minimumAbsoluteDifferenceInBst {

    // InOrder time: O(n) space: O(n)
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

    // DFS time: O(n) space: O(n)
    static int ans;
    static int prev;

    public static int getMinimumDifference_dfs(TreeNode root) {
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

    // InOrder + Stack time: O(n) space: O(n)
    public static int getMinimumDifference_stk(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();

        TreeNode preNode = null;
        TreeNode curNode = root;

        int min = Integer.MAX_VALUE;

        while (curNode != null || !stk.isEmpty()) {
            if (curNode != null) {
                stk.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stk.pop();
                if (preNode != null) {
                    min = Math.min(min, curNode.val - preNode.val);
                }
                preNode = curNode;
                curNode = curNode.right;
            }
        }

        return min;
    }

    public static int getMinimumDifference_bfs(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            nodeList.add(curNode.val);

            if (curNode.left != null) {
                queue.offer(curNode.left);
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }

        int ans = Integer.MAX_VALUE;

        Collections.sort(nodeList);

        for (int i = 0; i < nodeList.size() - 1; i++) {
            ans = Math.min(ans, nodeList.get(i + 1) - nodeList.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 3, 2, null});
        System.out.println("1 ?= " + getMinimumDifference(tst1));
        System.out.println("1 ?= " + getMinimumDifference_dfs(tst1));
        System.out.println("1 ?= " + getMinimumDifference_stk(tst1));
        System.out.println("1 ?= " + getMinimumDifference_bfs(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, null, 2});
        System.out.println("1 ?= " + getMinimumDifference(tst2));
        System.out.println("1 ?= " + getMinimumDifference_dfs(tst2));
        System.out.println("1 ?= " + getMinimumDifference_stk(tst2));
        System.out.println("1 ?= " + getMinimumDifference_bfs(tst2));
    }
}
