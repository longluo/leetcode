package com.longluo.leetcode.bfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1457. 二叉树中的伪回文路径
 * <p>
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * <p>
 * 示例 1：
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * <p>
 * 示例 2：
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 * 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * <p>
 * 示例 3：
 * 输入：root = [9]
 * 输出：1
 * <p>
 * 提示：
 * 给定二叉树的节点数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 9
 * <p>
 * https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class Problem1457_pseudoPalindromicPaths {

    // DFS time: O(n) space: O(n)
    // TLE
    static int ans = 0;

    public static int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ans = 0;

        dfs(root, new ArrayList<>());

        return ans;
    }

    private static void dfs(TreeNode root, List<Integer> path) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (check(path)) {
                ans++;
            }

            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            dfs(root.left, path);
        }

        if (root.right != null) {
            dfs(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    private static boolean check(List<Integer> numsList) {
        int len = numsList.size();
        int[] count = new int[10];
        for (int x : numsList) {
            count[x]++;
        }

        int cnt = 0;
        for (int x : count) {
            if (x % 2 == 0) {
                continue;
            }

            if (len % 2 == 0) {
                return false;
            } else {
                cnt++;
            }
        }

        return cnt <= 1;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 3, 1, 3, 1, null, 1});
        System.out.println("2 ?= " + pseudoPalindromicPaths(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1});
        System.out.println("1 ?= " + pseudoPalindromicPaths(tst2));
    }
}
