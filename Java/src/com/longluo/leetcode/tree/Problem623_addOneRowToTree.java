package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * <p>
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * 示例 1:
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * <p>
 * 示例 2:
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>
 * 提示:
 * 节点数在 [1, 10^4] 范围内
 * 树的深度在 [1, 10^4]范围内
 * -100 <= Node.val <= 100
 * -10^5 <= val <= 10^5
 * 1 <= depth <= the depth of tree + 1
 * <p>
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class Problem623_addOneRowToTree {

    // BFS time: O(n) space: O(n)
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth <= 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {
                    if (level == depth) {
                        TreeNode insertNode = new TreeNode(val);
                        TreeNode left = curNode.left;
                        curNode.left = insertNode;
                        insertNode.left = left;
                        queue.offer(left);
                    } else {
                        queue.offer(curNode.left);
                    }
                } else {
                    if (level == depth) {
                        TreeNode addLeftNode = new TreeNode(val);
                        curNode.left = addLeftNode;
                    }
                }

                if (curNode.right != null) {
                    if (level == depth) {
                        TreeNode insertNode = new TreeNode(val);
                        TreeNode right = curNode.right;
                        curNode.right = insertNode;
                        insertNode.right = right;
                        queue.offer(right);
                    } else {
                        queue.offer(curNode.right);
                    }
                } else {
                    if (level == depth) {
                        TreeNode addRightNode = new TreeNode(val);
                        curNode.right = addRightNode;
                    }
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4});
        TreeUtils.printTree(tst1);
        TreeUtils.printTree(addOneRow(tst1, 5, 4));
    }
}
