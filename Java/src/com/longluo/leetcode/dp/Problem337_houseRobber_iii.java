package com.longluo.leetcode.dp;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * <p>
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class Problem337_houseRobber_iii {

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left == null && root.right != null) {
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        }

        if (root.left != null && root.right == null) {
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        }

        return Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right), rob(root.left) + rob(root.right));
    }

    public static int rob_1(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    public static int robInternal(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int money = root.val;
        if (root.right != null) {
            money += robInternal(root.right.left, memo);
            money += robInternal(root.right.right, memo);
        }

        if (root.left != null) {
            money += robInternal(root.left.left, memo);
            money += robInternal(root.left.right, memo);
        }

        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode tstTree1 = TreeUtils.constructTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println("7 ?= " + rob(tstTree1));
        System.out.println("7 ?= " + rob_1(tstTree1));

        TreeNode tstTree2 = TreeUtils.constructTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        System.out.println("9 ?= " + rob(tstTree2));
        System.out.println("9 ?= " + rob_1(tstTree2));

        TreeNode tstTree3 = TreeUtils.constructTree(new Integer[]{3, 1, null, null, 2});
        System.out.println("5 ?= " + rob(tstTree3));
        System.out.println("5 ?= " + rob_1(tstTree3));
    }
}
