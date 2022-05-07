package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 543. 二叉树的直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * <p>
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class Problem543_diameterOfBinaryTree {

    // DFS time: O(n) space: O(n)
    static int ans = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);
        return ans - 1;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        ans = Math.max(ans, (left + right) + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("3 ?= " + diameterOfBinaryTree(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2});
        System.out.println("1 ?= " + diameterOfBinaryTree(tst2));
    }
}
