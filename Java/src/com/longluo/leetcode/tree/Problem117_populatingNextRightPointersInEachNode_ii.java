package com.longluo.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 示例：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * <p>
 * <p>
 * 提示：
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * <p>
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Problem117_populatingNextRightPointersInEachNode_ii {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // BFS time: O(n) space: O(n)
    public static Node connect_bfs(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                levelNodes.add(curNode);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            for (int i = 0; i < levelNodes.size() - 1; i++) {
                Node node = levelNodes.get(i);
                node.next = levelNodes.get(i + 1);
            }
        }

        return root;
    }

    // BFS Space Opt time: O(n) space: O(n)
    public static Node connect_bfs_opt(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            Node prev = null;
            for (int i = 0; i < levelCount; i++) {
                Node curNode = queue.poll();

                if (prev != null) {
                    prev.next = curNode;
                }

                prev = curNode;

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }

        return root;
    }


    public static void main(String[] args) {

    }
}
