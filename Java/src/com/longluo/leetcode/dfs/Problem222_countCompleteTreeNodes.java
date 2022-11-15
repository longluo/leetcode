package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * <p>
 * 提示：
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 * <p>
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 */
public class Problem222_countCompleteTreeNodes {

    // Recursion time: O(n) space: O(logn)
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        ans += 1;

        ans += countNodes(root.left);
        ans += countNodes(root.right);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println("6 ?= " + countNodes(tst1));
    }
}
