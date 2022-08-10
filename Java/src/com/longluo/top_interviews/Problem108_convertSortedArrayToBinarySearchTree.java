package com.longluo.top_interviews;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 按 严格递增 顺序排列
 * <p>
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Problem108_convertSortedArrayToBinarySearchTree {

    // DFS time: O(n) space: O(n)
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        int n = nums.length;
        return dfs(nums, 0, n - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

    // Iteration time: O(n) space: O(n)
    // TODO: 2022/8/10  
    public static TreeNode sortedArrayToBST_iter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int len = nums.length;
        TreeNode root = new TreeNode(nums[len / 2]);
        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeUtils.printTree(tst1);

        TreeNode tst2 = sortedArrayToBST(new int[]{1, 3});
        TreeUtils.printTree(tst2);

        TreeNode tst3 = sortedArrayToBST(new int[]{1});
        TreeUtils.printTree(tst3);

        TreeNode tst4 = sortedArrayToBST_iter(new int[]{-10, -3, 0, 5, 9});
        TreeUtils.printTree(tst4);
    }
}
