package com.longluo.assessment;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
 * Return the minimum number of moves required to make every node have exactly one coin.
 * <p>
 * Example 1:
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * <p>
 * Example 2:
 * Input: root = [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
 * <p>
 * <p>
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= n <= 100
 * 0 <= Node.val <= n
 * The sum of all Node.val is n.
 */
public class DistributeCoins {

    public static int ans = 0;

    public static int distributeCoins(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        ans += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeUtils.constructTree(new Integer[]{3, 0, 0});
        System.out.println("2 ?= " + distributeCoins(tree1));

        TreeNode tree2 = TreeUtils.constructTree(new Integer[]{0, 3, 0});
        System.out.println("3 ?= " + distributeCoins(tree2));
    }
}
