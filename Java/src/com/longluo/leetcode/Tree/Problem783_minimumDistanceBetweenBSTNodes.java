package com.longluo.leetcode.Tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 783. 二叉搜索树节点最小距离
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回树中任意两不同节点值之间的最小差值 。
 * <p>
 * 注意：本题与 530：https://leetcode.cn/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 10^5
 * <p>
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Problem783_minimumDistanceBetweenBSTNodes {

    // BFS + Sort time: O(n) space: O(n)
    public static int minDiffInBST_bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> numsList = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                numsList.add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }

        Collections.sort(numsList);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < numsList.size() - 1; i++) {
            ans = Math.min(ans, numsList.get(i + 1) - numsList.get(i));
        }

        return ans;
    }


    static int ans = Integer.MAX_VALUE;
    static int pre;

    public static int minDiffInBST(TreeNode root) {
        pre = -1;
        inOrder(root);
        return ans;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }

        inOrder(root.right);
    }


    // InOrder Opt time: O(n) space: O(n)
    public static int minDiffInBST_inorder(TreeNode root) {
        int[] ans = new int[2];

        ans[0] = -1;
        ans[1] = Integer.MAX_VALUE;

        inOrder(root, ans);
        return ans[1];
    }

    public static void inOrder(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }

        inOrder(root.left, res);

        if (res[0] == -1) {
            res[0] = root.val;
        } else {
            res[1] = Math.min(res[1], root.val - res[0]);
            res[0] = root.val;
        }

        inOrder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode tstTree1 = TreeUtils.constructTree(new Integer[]{4, 2, 6, 1, 3});
        System.out.println("1 ?= " + minDiffInBST(tstTree1));
        System.out.println("1 ?= " + minDiffInBST_bfs(tstTree1));
        System.out.println("1 ?= " + minDiffInBST_inorder(tstTree1));

        TreeNode tstTree2 = TreeUtils.constructTree(new Integer[]{1, 0, 48, null, null, 12, 49});
        System.out.println("1 ?= " + minDiffInBST(tstTree2));
        System.out.println("1 ?= " + minDiffInBST_bfs(tstTree2));
        System.out.println("1 ?= " + minDiffInBST_inorder(tstTree2));

        TreeNode tstTree3 = TreeUtils.constructTree(new Integer[]{90, 69, null, 49, 89, null, 52});
        System.out.println("1 ?= " + minDiffInBST(tstTree3));
    }
}
