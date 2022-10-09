package com.longluo.LCCUP;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 44. 开幕式焰火
 * <p>
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
 * <p>
 * 示例 1：
 * 输入：root = [1,3,2,1,null,2]
 * 输出：3
 * <p>
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 * <p>
 * 示例 2：
 * 输入：root = [3,3,3]
 * 输出：1
 * <p>
 * 解释：焰火中仅出现 1 个颜色，值为 3
 * <p>
 * 提示：
 * 1 <= 节点个数 <= 1000
 * 1 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/sZ59z6/
 */
public class LCP44_numColor {

    // DFS time: O(n) space: O(n)
    public static int numColor(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        return set.size();
    }

    private static void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }

        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 3, 2, 1, null, 2});
        System.out.println("3 ?= " + numColor(tst1));
    }
}
