package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;

import java.util.*;

/**
 * 99. 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * 提示：
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class Problem99_recoverBinarySearchTree {

    // BF + InOrder + Sort time: O(n) space: O(n)
    public static void recoverTree_bf(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        inOrder(root, nodeList);
        int len = nodeList.size();
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = nodeList.get(i).val;
        }
        Arrays.sort(values);
        int first = -1;
        int second = -1;
        for (int i = 0; i < len; i++) {
            if (values[i] != nodeList.get(i).val) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                    break;
                }
            }
        }

        int temp = nodeList.get(first).val;
        nodeList.get(first).val = nodeList.get(second).val;
        nodeList.get(second).val = temp;
    }

    public static void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {

    }
}
