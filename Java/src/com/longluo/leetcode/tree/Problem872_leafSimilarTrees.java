package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 872. 叶子相似的树
 * <p>
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 * <p>
 * https://leetcode.cn/problems/leaf-similar-trees/
 */
public class Problem872_leafSimilarTrees {

    // DFS time: O(m+n) space: O(m+n)
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        List<Integer> leafList1 = new ArrayList<>();
        dfs(root1, leafList1);

        List<Integer> leafList2 = new ArrayList<>();
        dfs(root2, leafList2);

        return leafList1.equals(leafList2);
    }

    public static void dfs(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafList.add(root.val);
            return;
        }

        dfs(root.left, leafList);
        dfs(root.right, leafList);
    }

    // Stack time: O(m+n) space: O(m+n)
    public static boolean leafSimilar_iterate(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();

        inOrder(root1, seq1);
        inOrder(root2, seq2);

        return seq1.equals(seq2);
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.empty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();

            if (root.left == null && root.right == null) {
                list.add(root.val);
            }

            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode treeNode2 = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        System.out.println("true ?= " + leafSimilar(treeNode1, treeNode2));
        System.out.println("true ?= " + leafSimilar_iterate(treeNode1, treeNode2));

        TreeNode treeNode3 = TreeUtils.constructTree(new Integer[]{1});
        TreeNode treeNode4 = TreeUtils.constructTree(new Integer[]{1});
        System.out.println("true ?= " + leafSimilar(treeNode3, treeNode4));
        System.out.println("true ?= " + leafSimilar_iterate(treeNode3, treeNode4));

        TreeNode treeNode5 = TreeUtils.constructTree(new Integer[]{1});
        TreeNode treeNode6 = TreeUtils.constructTree(new Integer[]{2});
        System.out.println("false ?= " + leafSimilar(treeNode5, treeNode6));
        System.out.println("false ?= " + leafSimilar_iterate(treeNode5, treeNode6));

        TreeNode treeNode7 = TreeUtils.constructTree(new Integer[]{1, 2});
        TreeNode treeNode8 = TreeUtils.constructTree(new Integer[]{2, 2});
        System.out.println("true ?= " + leafSimilar(treeNode7, treeNode8));
        System.out.println("true ?= " + leafSimilar_iterate(treeNode7, treeNode8));

        TreeNode treeNode9 = TreeUtils.constructTree(new Integer[]{1, 2, 3});
        TreeNode treeNode10 = TreeUtils.constructTree(new Integer[]{1, 3, 2});
        System.out.println("false ?= " + leafSimilar(treeNode9, treeNode10));
        System.out.println("false ?= " + leafSimilar_iterate(treeNode9, treeNode10));

        TreeNode treeNode11 = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 11, null, null, 8, 10});
        TreeNode treeNode12 = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        System.out.println("false ?= " + leafSimilar(treeNode11, treeNode12));
        System.out.println("false ?= " + leafSimilar_iterate(treeNode11, treeNode12));
    }
}
