package com.longluo.leetcode.tree;

import com.longluo.datastructure.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * 提示：
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 10^4] 之间。
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Problem559_maximumDepthOfNAryTree {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> depthList = new LinkedList<>();
            for (Node child : root.children) {
                depthList.add(maxDepth(child));
            }

            return Collections.max(depthList) + 1;
        }
    }

    public static int maxDepth_dfs(Node root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 1);
    }

    public static int dfs(Node root, int depth) {
        if (root == null) {
            return depth;
        }

        List<Node> children = root.children;
        int size = children.size();
        int[] depthArray = new int[size];
        for (int i = 0; i < size; i++) {
            if (children.get(i) != null) {
                depthArray[i] = dfs(children.get(i), depth + 1);
            }
        }

        int ans = depth;
        for (int i = 0; i < size; i++) {
            ans = Math.max(ans, depthArray[i]);
        }

        return ans;
    }

    static class QueueNode {
        Node node;
        int depth;

        QueueNode(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static int maxDepth_bfs(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            Node node = queueNode.node;
            int depth = queueNode.depth;
            maxDepth = Math.max(depth, maxDepth);
            if (node.children != null) {
                List<Node> children = node.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(new QueueNode(child, depth + 1));
                    }
                }
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {

    }
}
