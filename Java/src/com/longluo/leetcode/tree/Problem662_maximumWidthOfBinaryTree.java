package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * <p>
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * 示例 1：
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * <p>
 * 示例 2：
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * <p>
 * 示例 3：
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * <p>
 * 提示：
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class Problem662_maximumWidthOfBinaryTree {

    // BFS time: O(n) space: O(n)
    // TLE
    public static int widthOfBinaryTree_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int width = getMaxWidth(queue);
            if (width == 0) {
                break;
            }
            maxWidth = Math.max(maxWidth, width);
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }
        }

        return maxWidth;
    }

    private static int getMaxWidth(Queue<TreeNode> queue) {
        List<TreeNode> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            nodeList.add(queue.poll());
        }

        for (TreeNode node : nodeList) {
            queue.offer(node);
        }

        int len = nodeList.size();
        boolean isNull = true;
        int left = -1;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nodeList.get(i) != null && left < 0) {
                isNull = false;
                left = i;
            } else if (nodeList.get(i) != null && left >= 0) {
                right = i;
                isNull = false;
            }
        }

        if (isNull) {
            return 0;
        }

        return right < 0 ? 1 : right - left + 1;
    }

    // BFS Opt time: O(n) space: O(n)
    // TLE
    public static int widthOfBinaryTree_bfs_opt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isNull = true;
            int left = -1;
            int right = -1;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null && left < 0) {
                    isNull = false;
                    left = i;
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else if (curNode != null && left >= 0) {
                    isNull = false;
                    right = i;
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }

            if (isNull) {
                break;
            }

            maxWidth = Math.max(maxWidth, right < 0 ? 1 : right - left + 1);
        }

        return maxWidth;
    }

    public static int widthOfBinaryTree_bfs_opt2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            boolean isNull = true;
            int left = -1;
            int right = -1;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null && left < 0) {
                    isNull = false;
                    left = i;
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else if (curNode != null && left >= 0) {
                    isNull = false;
                    right = i;
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }

            if (isNull) {
                break;
            }

            if (level > 1 && right < 0) {
                break;
            }

            maxWidth = Math.max(maxWidth, right < 0 ? 1 : right - left + 1);
        }

        return maxWidth;
    }

    // BFS time: O(n) space: O(n)
    public static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 1;
        List<Pair<TreeNode, Integer>> nodeList = new ArrayList<>();
        nodeList.add(new Pair<>(root, 1));

        while (!nodeList.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmpList = new ArrayList<>();
            for (Pair<TreeNode, Integer> curPair : nodeList) {
                TreeNode curNode = curPair.getKey();
                int index = curPair.getValue();
                if (curNode.left != null) {
                    tmpList.add(new Pair<>(curNode.left, 2 * index));
                }
                if (curNode.right != null) {
                    tmpList.add(new Pair<>(curNode.right, 2 * index + 1));
                }
            }

            int len = nodeList.size();
            maxWidth = Math.max(maxWidth, nodeList.get(len - 1).getValue() - nodeList.get(0).getValue() + 1);
            nodeList = tmpList;
        }

        return maxWidth;
    }

    static class Pair<K, V> {
        TreeNode key;
        Integer value;

        public Pair(TreeNode key, int value) {
            this.key = key;
            this.value = value;
        }

        public TreeNode getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    // DFS
    // TODO: 2022/8/27  
    
    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
        System.out.println("4 ?= " + widthOfBinaryTree_bfs(tst1));
        System.out.println("4 ?= " + widthOfBinaryTree_bfs_opt(tst1));
        System.out.println("4 ?= " + widthOfBinaryTree_bfs_opt2(tst1));
        System.out.println("4 ?= " + widthOfBinaryTree(tst1));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7});
        System.out.println("7 ?= " + widthOfBinaryTree(tst2));
    }
}
