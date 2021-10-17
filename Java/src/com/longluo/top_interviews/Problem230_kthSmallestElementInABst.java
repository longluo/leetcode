package com.longluo.top_interviews;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class Problem230_kthSmallestElementInABst {

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        return nums.get(k - 1);
    }

    public static void inOrder(TreeNode root, List<Integer> numberList) {
        if (root == null) {
            return;
        }

        inOrder(root.left, numberList);
        numberList.add(root.val);
        inOrder(root.right, numberList);
    }

    public static void main(String[] args) {

    }
}
