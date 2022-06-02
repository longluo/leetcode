package com.longluo.contest.weekly_contest_292;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2265. 统计值等于子树平均值的节点数
 * <p>
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 * <p>
 * 注意：
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 * <p>
 * 示例 1：
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：1
 * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/count-nodes-equal-to-average-of-subtree/
 */
public class Problem2265_averageOfSubtree {

    static int cnt = 0;

    // TODO: 2022/6/2  
    public static int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return cnt;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> nodeList = new ArrayList<>();
        sumOfTree(root, nodeList);
        int sum = 0;
        for (int val : nodeList) {
            sum += val;
        }

        if (sum / nodeList.size() == root.val) {
            cnt++;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public static void sumOfTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        sumOfTree(root.left, list);
        sumOfTree(root.right, list);
    }

    public static void main(String[] args) {

    }
}
