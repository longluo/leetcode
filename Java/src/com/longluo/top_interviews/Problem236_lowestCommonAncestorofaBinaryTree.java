package com.longluo.top_interviews;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 10^5] 内。
 * -10^9 <= Node.val <= 10^9
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Problem236_lowestCommonAncestorofaBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        List<TreeNode> pList = getPath(root, p);
        List<TreeNode> qList = getPath(root, q);
        int pIdx = 0;
        int qIdx = 0;
        while (pIdx < pList.size() || qIdx < qList.size()) {
            if (pList.get(pIdx).equals(qList.get(qIdx))) {
                return pList.get(pIdx);
            }

            if (pIdx == pList.size() - 1 && qIdx < qList.size()) {
                return pList.get(pIdx);
            }

            if (pIdx < pList.size() && qIdx == qList.size() - 1) {
                return qList.get(qIdx);
            }

            pIdx++;
            qIdx++;
        }

        return root;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(ans, root, target);
        return ans;
    }

    public static void dfs(List<TreeNode> list, TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        if (root == target) {
            list.add(target);
            return;
        }

        list.add(root);
        if (root.left != null) {
            dfs(list, root.left, target);
        }

        if (root.right != null) {
            dfs(list, root.right, target);
        }
    }

    public static TreeNode lowestCommonAncestor_rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor_rec(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor_rec(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(lowestCommonAncestor(tst1, tst1.left, tst1.right));
        System.out.println(lowestCommonAncestor(tst1, tst1.left, tst1.left.right.right));
        System.out.println(lowestCommonAncestor_rec(tst1, tst1.left, tst1.left.right.right));
    }
}
