package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 * <p>
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * 输出: True
 * <p>
 * 案例 2:
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * 输出: False
 * <p>
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Problem653_twoSumIvInputIsABst {

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> numsList = new ArrayList<>();
        dfs(root, numsList);
        Collections.sort(numsList);
        for (int i = 0; i < numsList.size(); i++) {
            int rest = k - numsList.get(i);
            if (binarySearch(numsList, i + 1, numsList.size() - 1, rest)) {
                return true;
            }
        }

        return false;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }

    public static boolean findTarget_2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);
        int n = numsList.size();
        for (int i = 0; i < n; i++) {
            int rest = k - numsList.get(i);
            if (binarySearch(numsList, i + 1, n - 1, rest)) {
                return true;
            }
        }

        return false;
    }

    public static boolean findTarget_3(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);
        int n = numsList.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = numsList.get(left) + numsList.get(right);
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static boolean binarySearch(List<Integer> list, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == list.get(mid)) {
                return true;
            } else if (target < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static boolean findTarget_4(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public static boolean dfs(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }

        if (set.contains(target - root.val)) {
            return true;
        }

        set.add(root.val);
        return dfs(root.left, set, target) || dfs(root.right, set, target);
    }

    public static boolean findTarget_bfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{5, 3, 6, 2, 4, 7});
        System.out.println("true ?= " + findTarget(tst1, 9));
        System.out.println("true ?= " + findTarget_2(tst1, 9));
        System.out.println("true ?= " + findTarget_3(tst1, 9));
        System.out.println("true ?= " + findTarget_4(tst1, 9));
        System.out.println("true ?= " + findTarget_bfs(tst1, 9));
        System.out.println("false ?= " + findTarget(tst1, 28));
        System.out.println("false ?= " + findTarget_2(tst1, 28));
        System.out.println("false ?= " + findTarget_3(tst1, 28));
        System.out.println("false ?= " + findTarget_4(tst1, 28));
        System.out.println("false ?= " + findTarget_bfs(tst1, 28));
    }
}
