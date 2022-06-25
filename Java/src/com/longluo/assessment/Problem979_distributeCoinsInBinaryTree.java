package com.longluo.assessment;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 979. 在二叉树中分配硬币
 * <p>
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * <p>
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 * <p>
 * 示例 1：
 * 输入：[3,0,0]
 * 输出：2
 * 解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
 * <p>
 * 示例 2：
 * 输入：[0,3,0]
 * 输出：3
 * 解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
 * <p>
 * 示例 3：
 * 输入：[1,0,2]
 * 输出：2
 * <p>
 * 示例 4：
 * 输入：[1,0,0,null,3]
 * 输出：4
 * <p>
 * 提示：
 * 1<= N <= 100
 * 0 <= node.val <= N
 * <p>
 * https://leetcode.cn/problems/distribute-coins-in-binary-tree/
 */
public class Problem979_distributeCoinsInBinaryTree {

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
