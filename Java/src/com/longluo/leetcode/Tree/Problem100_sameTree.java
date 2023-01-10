package com.longluo.leetcode.Tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * <p>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * https://leetcode.cn/problems/same-tree/
 */
public class Problem100_sameTree {

    // DFS time: O(n) space: O(n)
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // BFS time: O(n) space: O(n)
    public static boolean isSameTree_bfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();

        queueA.offer(p);
        queueB.offer(q);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (queueA.size() != queueB.size()) {
                return false;
            }

            int size = queueA.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNodeA = queueA.poll();
                TreeNode curNodeB = queueB.poll();

                if (curNodeA == null && curNodeB == null) {
                    continue;
                }

                if (curNodeA == null || curNodeB == null || curNodeA.val != curNodeB.val) {
                    return false;
                }

                queueA.offer(curNodeA.left);
                queueA.offer(curNodeA.right);

                queueB.offer(curNodeB.left);
                queueB.offer(curNodeB.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3});
        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, 2, 3});

        System.out.println("true ?= " + isSameTree(tst1, tst2));
        System.out.println("true ?= " + isSameTree_bfs(tst1, tst2));
    }
}
