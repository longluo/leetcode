package com.longluo.algo200;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;
import kotlin.Pair;

import java.util.*;

/**
 * 314. 二叉树的垂直遍历
 * <p>
 * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
 * <p>
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * <p>
 * 示例 2：
 * 输入：root = [3,9,8,4,0,1,7]
 * 输出：[[4],[9],[3,0,1],[8],[7]]
 * <p>
 * 示例 3：
 * 输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * 输出：[[4],[9,5],[3,0,1],[8,2],[7]]
 * <p>
 * 提示：
 * 树中结点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-vertical-order-traversal/
 */
public class Problem314_verticalOrderTraversal {

    // BFS time: O(n) space: O(n)
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<int[]> nodeList = new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            TreeNode curNode = cur.node;
            int index = cur.index;
            nodeList.add(new int[]{curNode.val, index});

            if (curNode.left != null) {
                Pair left = new Pair(curNode.left, index - 1);
                queue.offer(left);
            }

            if (curNode.right != null) {
                Pair right = new Pair(curNode.right, index + 1);
                queue.offer(right);
            }
        }

        Collections.sort(nodeList, (a, b) -> a[1] - b[1]);

        int n = nodeList.size();

        List<Integer> vertList = new ArrayList<>();
        int idx = nodeList.get(0)[1];
        vertList.add(nodeList.get(0)[0]);

        for (int i = 1; i < n; i++) {
            if (nodeList.get(i)[1] == idx) {
                vertList.add(nodeList.get(i)[0]);
            } else {
                ans.add(new ArrayList<>(vertList));
                vertList.clear();

                idx = nodeList.get(i)[1];
                vertList.add(nodeList.get(i)[0]);
            }
        }

        ans.add(new ArrayList<>(vertList));

        return ans;
    }

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeUtils.printTree(tst1);
        System.out.println("[[9], [3, 15], [20], [7]] ?= " + verticalOrder(tst1));
    }
}
