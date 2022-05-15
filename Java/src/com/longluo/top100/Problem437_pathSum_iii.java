package com.longluo.top100;

import com.longluo.datastructure.TreeNode;

/**
 * 437. 路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class Problem437_pathSum_iii {

    public static int ans = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public static int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    public static void main(String[] args) {

    }
}
