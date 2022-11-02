package com.longluo.contest.biweekly_contest_82;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * https://leetcode.cn/contest/biweekly-contest-82/
 */

/**
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 */
public class Problem1 {

    public static boolean evaluateTree(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return root.val > 0;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        } else {
            return left && right;
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 1, 3, null, null, 0, 1});
        System.out.println("true ?= " + evaluateTree(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{0});
        System.out.println("false ?= " + evaluateTree(tst2));
    }
}
