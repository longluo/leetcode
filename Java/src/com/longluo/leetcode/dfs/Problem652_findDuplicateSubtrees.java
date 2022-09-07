package com.longluo.leetcode.dfs;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * <p>
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * <p>
 * 示例 2：
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * <p>
 * 提示：
 * 树中的结点数在[1, 10^4]范围内。
 * -200 <= Node.val <= 200
 * <p>
 * https://leetcode.cn/problems/find-duplicate-subtrees/
 */
public class Problem652_findDuplicateSubtrees {

    // DFS time: O(n) space: O(n)
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();

        Map<String, List<TreeNode>> nodeMap = new HashMap<>();

        dfs(nodeMap, root);

        for (Map.Entry<String, List<TreeNode>> entry : nodeMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                ans.add(entry.getValue().get(0));
            }
        }

        return ans;
    }

    private static void dfs(Map<String, List<TreeNode>> nodeMap, TreeNode root) {
        if (root == null) {
            return;
        }

        String res = tree2str(root);
        if (nodeMap.containsKey(res)) {
            nodeMap.get(res).add(root);
        } else {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            nodeMap.put(res, list);
        }

        dfs(nodeMap, root.left);
        dfs(nodeMap, root.right);
    }

    private static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }

        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
        System.out.println(" " + findDuplicateSubtrees(tst1));
    }
}
