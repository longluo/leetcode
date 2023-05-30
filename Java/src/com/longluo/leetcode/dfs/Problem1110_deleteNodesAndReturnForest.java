package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. 删点成林
 * <p>
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * 提示：
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * https://leetcode.cn/problems/delete-nodes-and-return-forest/
 */
public class Problem1110_deleteNodesAndReturnForest {

    // DFS + HashSet time: O(m+n) space: O(n)
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int x : to_delete) {
            toDeleteSet.add(x);
        }

        if (dfs(root, toDeleteSet, roots) != null) {
            roots.add(root);
        }

        return roots;
    }

    private static TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> roots) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left, toDeleteSet, roots);
        root.right = dfs(root.right, toDeleteSet, roots);

        if (!toDeleteSet.contains(root.val)) {
            return root;
        }

        if (root.left != null) {
            roots.add(root.left);
        }

        if (root.right != null) {
            roots.add(root.right);
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<TreeNode> res1 = delNodes(tst1, new int[]{3, 5});
        for (TreeNode node : res1) {
            TreeUtils.printTree(node);
        }
    }
}
