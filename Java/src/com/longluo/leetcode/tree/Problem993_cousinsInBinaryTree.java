package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class Problem993_cousinsInBinaryTree {

    static TreeNode xParent = null;
    static int depthX = 0;
    static boolean xFound = false;

    static TreeNode yParent = null;
    static int depthY = 0;
    static boolean yFound = false;

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xParent != yParent && depthX == depthY;
    }

    public static void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xFound = true;
            xParent = parent;
            depthX = level;
        }

        if (root.val == y) {
            yFound = true;
            yParent = parent;
            depthY = level;
        }

        if (xFound && yFound) {
            return;
        }

        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);
    }

    public static boolean isCousins_2(TreeNode root, int x, int y) {
        TreeNode xParent = null;
        TreeNode yParent = null;
        int depthX = 0;
        int depthY = 0;
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    int val = node.left.val;
                    if (val == x) {
                        depthX = depth + 1;
                        xParent = node;
                    } else if (val == y) {
                        depthY = depth + 1;
                        yParent = node;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    int val = node.right.val;
                    if (val == x) {
                        depthX = depth + 1;
                        xParent = node;
                    } else if (val == y) {
                        depthY = depth + 1;
                        yParent = node;
                    }
                    queue.offer(node.right);
                }
            }
        }

        return depthX == depthY && xParent != yParent;
    }

    public static void main(String[] args) {
        TreeNode tstTree1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4});
        TreeUtils.printTree(tstTree1);
        System.out.println("false ?= " + isCousins(tstTree1, 4, 3));
        System.out.println("false ?= " + isCousins_2(tstTree1, 4, 3));

        TreeNode tstTree2 = TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 4, null, 5});
        TreeUtils.printTree(tstTree2);
        System.out.println("true ?= " + isCousins(tstTree2, 5, 4));
        System.out.println("true ?= " + isCousins_2(tstTree2, 5, 4));

        TreeNode tstTree3 = TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 4});
        TreeUtils.printTree(tstTree3);
        System.out.println("false ?= " + isCousins(tstTree3, 2, 3));
        System.out.println("false ?= " + isCousins_2(tstTree3, 2, 3));
    }
}
