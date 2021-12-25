package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1609. 奇偶树
 * <p>
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * <p>
 * 示例 3：
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * <p>
 * 示例 4：
 * 输入：root = [1]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 * <p>
 * 提示：
 * 树中节点数在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/even-odd-tree/
 */
public class Problem1609_evenOddTree {

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val % 2 == 0) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> valueList = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            valueList.clear();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                valueList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (level % 2 == 0) {
                if (!isIncreaseList(valueList, true)) {
                    return false;
                }
            } else {
                if (!isIncreaseList(valueList, false)) {
                    return false;
                }
            }
            level++;
        }

        return true;
    }

    public static boolean isIncreaseList(List<Integer> list, boolean isIncrease) {
        if (list.size() <= 1) {
            if (isIncrease) {
                if (list.get(0) % 2 == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (list.get(0) % 2 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        int len = list.size();
        if (isIncrease) {
            for (int i = 0; i < len; i++) {
                if (list.get(i) % 2 == 0) {
                    return false;
                }
                if (i + 1 < len && list.get(i + 1) <= list.get(i)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (list.get(i) % 2 == 1) {
                    return false;
                }
                if (i + 1 < len && list.get(i + 1) >= list.get(i)) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtils.constructTree(new Integer[]{5, 4, 2, 3, 3, 7});
        System.out.println("false ?= " + isEvenOddTree(treeNode1));

        TreeNode treeNode2 = TreeUtils.constructTree(new Integer[]{11, 18, 14, 3, 7, null, null, null, null, 18, null, 6});
        System.out.println("false ?= " + isEvenOddTree(treeNode2));
    }
}
