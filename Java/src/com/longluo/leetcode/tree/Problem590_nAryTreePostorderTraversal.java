package com.longluo.leetcode.tree;

import com.longluo.datastructure.Node;

import java.util.*;

/**
 * 590. N 叉树的后序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * 提示：
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class Problem590_nAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    public void postOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        for (Node child : children) {
            postOrder(child, list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder_iter(Node root) {
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
            for (int i = 0; i < size; i++) {
                stack.push(children.get(i));
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public List<Integer> postorder_iter_2(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeLast();
            ans.addFirst(node.val);
            List<Node> children = node.children;
            int size = children.size();
            for (int i = 0; i < size; i++) {
                stack.addLast(children.get(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
