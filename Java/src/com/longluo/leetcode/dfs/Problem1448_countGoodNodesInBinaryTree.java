package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 1448. Count Good Nodes in Binary Tree
 * <p>
 * Medium
 * <p>
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * <p>
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * Constraints:
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 * <p>
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class Problem1448_countGoodNodesInBinaryTree {

    // DFS time: O(n) space: O(n)
    static int ans = 0;

    public static int goodNodes(TreeNode root) {
        ans = 0;
        dfs(root, root.val);
        return ans;
    }

    private static void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            max = root.val;
            ans++;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
        System.out.println("4 ?= " + goodNodes(tst1));
    }
}
