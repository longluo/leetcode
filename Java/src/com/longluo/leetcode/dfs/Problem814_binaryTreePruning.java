package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 814. Binary Tree Pruning
 * <p>
 * Medium
 * <p>
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * A subtree of a node node is node plus every node that is a descendant of node.
 * <p>
 * Example 1:
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * <p>
 * Example 2:
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * <p>
 * Example 3:
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 200].
 * Node.val is either 0 or 1.
 * <p>
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class Problem814_binaryTreePruning {

    // DFS time: O(n) space: O(n)
    public static TreeNode pruneTree_dfs(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private static boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);

        if (!left) {
            root.left = null;
        }

        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;
    }

    // Recursion time: O(n) space: O(n)
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 0, 0, 1});
        TreeUtils.printTree(pruneTree(tst1));
        TreeUtils.printTree(pruneTree_dfs(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 0, 1, 0, 0, 0, 1});
        TreeUtils.printTree(pruneTree_dfs(tst2));

        TreeNode tst3 = TreeUtils.constructTree(new Integer[]{0, null, 0, 0, 0});
        TreeUtils.printTree(pruneTree_dfs(tst3));
    }
}
