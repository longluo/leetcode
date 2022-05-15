package com.longluo.top100;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * 538. 把二叉搜索树转换为累加树
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * <p>
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * <p>
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * <p>
 * 提示：
 * 树中的节点数介于 0 和 10^4 之间。
 * 每个节点的值介于 -10^4 和 10^4 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 * <p>
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class Problem538_convertBSTToGreaterTree {

    // BF InOrder and InOrder time: O(2 * n) space: O(n)
    public static TreeNode convertBST_bf(TreeNode root) {
        if (root == null) {
            return root;
        }

        List<Integer> list = new ArrayList<>();
        TreeNode pNode = root;
        inOrder(pNode, list);
        int len = list.size();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            map.put(list.get(i), sum);
            sum += list.get(i);
        }

        pNode = root;
        Stack<TreeNode> stk = new Stack<>();
        while (pNode != null || !stk.empty()) {
            while (pNode != null) {
                stk.push(pNode);
                pNode = pNode.left;
            }

            pNode = stk.pop();
            pNode.val = sum - map.get(pNode.val);
            pNode = pNode.right;
        }

        return root;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // Recursion time: O(n) space: O(1)
    public static TreeNode convertBST_recur(TreeNode root) {
        if (root == null) {
            return root;
        }
        postOrder(root);
        return root;
    }

    static int sum = 0;

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.right);
        sum += root.val;
        root.val = sum;
        postOrder(root.left);
    }

    // Recursive time: O(n) space: O(n)
    public static TreeNode convertBST_recur_opt(TreeNode root) {
        if (root != null) {
            convertBST_recur_opt(root.right);
            sum += root.val;
            root.val = sum;
            convertBST_recur_opt(root.left);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
//        convertBST_bf(tst1);
        convertBST_recur(tst1);
    }
}
