package com.longluo.leetcode.tree;

import com.longluo.datastructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 * <p>
 * Medium
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * <p>
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class Problem429_levelOrder {

    // BFS time: O(n) space: O(n)
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    levelList.add(node.val);

                    List<Node> children = node.children;
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }

            ans.add(levelList);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
