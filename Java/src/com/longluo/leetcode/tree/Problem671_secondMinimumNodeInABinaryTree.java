package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * 671. 二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，
 * 那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 2^31 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class Problem671_secondMinimumNodeInABinaryTree {

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return Math.min(left, right);
        }
    }

    public static int findSecondMinimumValue_dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        List<Integer> numList = new ArrayList<>();
        dfs(root, numList);
        Collections.sort(numList);
        int n = numList.size();
        int ans = -1;
        int base = numList.get(0);
        for (int i = 1; i < n; i++) {
            if (numList.get(i) != base) {
                return numList.get(i);
            }
        }

        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static int findSecondMinimumValue_bfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> numList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            numList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        Collections.sort(numList);
        int n = numList.size();
        int ans = -1;
        int base = numList.get(0);
        for (int i = 1; i < n; i++) {
            if (numList.get(i) != base) {
                return numList.get(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 2, 5, null, null, 5, 7});
        System.out.println("5 ?= " + findSecondMinimumValue(tst1));
        System.out.println("5 ?= " + findSecondMinimumValue_dfs(tst1));
        System.out.println("5 ?= " + findSecondMinimumValue_bfs(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{2, 2, 2});
        System.out.println("-1 ?= " + findSecondMinimumValue(tst2));
        System.out.println("-1 ?= " + findSecondMinimumValue_dfs(tst2));
        System.out.println("-1 ?= " + findSecondMinimumValue_bfs(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1});
        System.out.println("2 ?= " + findSecondMinimumValue(tst3));
        System.out.println("2 ?= " + findSecondMinimumValue_dfs(tst3));
        System.out.println("2 ?= " + findSecondMinimumValue_bfs(tst3));
    }
}
