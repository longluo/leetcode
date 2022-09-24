package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode.cn/problems/path-sum-ii/
 */
public class Problem113_pathSum_ii {

    // DFS time: O(n) space: O(n)
    // TODO: 2022/9/24  
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(ans, new ArrayList<>(), root, targetSum);
        return ans;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(path));
        }

        dfs(res, path, root.left, targetSum - root.val);
        dfs(res, path, root.right, targetSum - root.val);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        TreeUtils.printTree(tst1);
        System.out.println("[[5, 4, 11, 2], [5, 8, 4, 5]] ?= " + pathSum(tst1, 22));
    }
}
