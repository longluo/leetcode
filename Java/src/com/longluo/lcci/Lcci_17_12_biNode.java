package com.longluo.lcci;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 17.12. BiNode
 * <p>
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，
 * 要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 提示：
 * 节点数量不会超过 100000。
 * <p>
 * https://leetcode.cn/problems/binode-lcci/?favorite=xb9lfcwi
 */
public class Lcci_17_12_biNode {

    // DFS time: O(n) space: O(n)
    public static TreeNode convertBiNode_bf(TreeNode root) {
        if (root == null) {
            return root;
        }

        List<TreeNode> nodeList = new ArrayList<>();

        traversal(root, nodeList);

        int len = nodeList.size();

        for (int i = 0; i < len; i++) {
            TreeNode curNode = nodeList.get(i);
            curNode.right = i == len - 1 ? null : nodeList.get(i + 1);
            curNode.left = null;
        }


        return nodeList.get(0);
    }

    private static void traversal(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        traversal(root.left, nodeList);
        nodeList.add(root);
        traversal(root.right, nodeList);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{4, 2, 5, 1, 3, null, 6, 0});
        TreeUtils.printTree(tst1);
        convertBiNode_bf(tst1);
    }
}
