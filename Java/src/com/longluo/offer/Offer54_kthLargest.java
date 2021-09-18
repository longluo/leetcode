package com.longluo.offer;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Offer54_kthLargest {

    public static List<Integer> numList = new LinkedList<>();

    public static int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        getNumList(root);
        Collections.sort(numList);
        int size = numList.size();
        return numList.get(size - k);
    }

    public static void getNumList(TreeNode root) {
        if (root == null) {
            return;
        }

        numList.add(root.val);
        getNumList(root.left);
        getNumList(root.right);
    }

    public static int kthLargest_2(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        searchList(root);
        int size = numList.size();
        return numList.get(size - k);
    }

    public static void searchList(TreeNode root) {
        if (root == null) {
            return;
        }

        getNumList(root.left);
        numList.add(root.val);
        getNumList(root.right);
    }

    public static int ans = 0;
    public static int kThVal = 0;

    public static int kthLargest_3(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        kThVal = k;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        kThVal--;
        if (kThVal == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode tstNode1 = TreeUtils.constructTree(new Integer[]{3, 1, 4, null, 2});
        System.out.println("4 ?= " + kthLargest(tstNode1, 1));
        System.out.println("4 ?= " + kthLargest_2(tstNode1, 1));
        System.out.println("4 ?= " + kthLargest_3(tstNode1, 1));
    }
}
