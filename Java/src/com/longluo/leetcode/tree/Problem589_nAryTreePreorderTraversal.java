package com.longluo.leetcode.tree;

import com.longluo.datastructure.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * 提示：
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Problem589_nAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        preOrder(root, ans);
        return ans;
    }

    public void preOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            preOrder(child, list);
        }
    }

    public List<Integer> preorder_iter(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            int size = children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
