package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Problem235_lowestCommonAncestorOfABinarySearchTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ans = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean isFound = findTargetNode(node, p) && findTargetNode(node, q);
            boolean isLeftChildFound = findTargetNode(node.left, p) && findTargetNode(node.left, q);
            boolean isRightChildFound = findTargetNode(node.right, p) && findTargetNode(node.right, q);
            if (isFound && !isLeftChildFound && !isRightChildFound) {
                return node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return ans;
    }

    public static boolean findTargetNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            return true;
        }

        return findTargetNode(root.left, node) || findTargetNode(root.right, node);
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }

        return ancestor;
    }

    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodePPath = getPath(root, p);
        List<TreeNode> nodeQPath = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < nodePPath.size() && i < nodeQPath.size(); i++) {
            if (nodePPath.get(i) == nodePPath.get(i)) {
                ancestor = nodePPath.get(i);
            } else {
                break;
            }
        }

        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode targetNode) {
        List<TreeNode> ans = new ArrayList<>();
        while (root != null) {
            ans.add(root);
            if (root.val > targetNode.val) {
                root = root.left;
            } else if (root.val < targetNode.val) {
                root = root.right;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
