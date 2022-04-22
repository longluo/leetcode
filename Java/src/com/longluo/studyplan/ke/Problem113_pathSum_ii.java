package com.longluo.studyplan.ke;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Problem113_pathSum_ii {

    // DFS
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        } else if (root.left == null && root.right == null && root.val == targetSum) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
            return ans;
        }

        List<Integer> leftList = new ArrayList<>();
        leftList.add(root.val);
        dfs(root.left, ans, leftList, targetSum - root.val);
        List<Integer> rightList = new ArrayList<>();
        rightList.add(root.val);
        dfs(root.right, ans, rightList, targetSum - root.val);
        return ans;
    }

    public static void dfs(TreeNode root, List<List<Integer>> res, List<Integer> valList, int targetSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                valList.add(root.val);
                res.add(new ArrayList<>(valList));
            }

            return;
        }

        targetSum -= root.val;
        valList.add(root.val);
        if (root.left != null) {
            dfs(root.left, res, valList, targetSum);
        }

        if (root.right != null) {
            dfs(root.right, res, valList, targetSum);
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println("[[5, 4, 11, 2], [5, 8, 4, 5]] ?= " + pathSum(tst1, 22));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("[[1]] ?= " + pathSum(tst2, 1));
    }
}
