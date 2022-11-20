package com.longluo.contest.weekly_contest_320;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-320
 */
public class Problem2 {

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);

        for (int x : queries) {
            List<Integer> item = new ArrayList<>();

            int min = binarySearchMin(numsList, x);
            int max = binarySearchMax(numsList, x);

            item.add(min);
            item.add(max);

            ans.add(item);
        }

        return ans;
    }

    private static void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    private static int binarySearchMin(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        if (list.get(left) > target) {
            return -1;
        }

        if (list.get(right) <= target) {
            return list.get(right);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return list.get(left);
    }

    private static int binarySearchMax(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        if (list.get(left) >= target) {
            return list.get(left);
        }

        if (list.get(right) < target) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return list.get(left);
    }

    public static List<List<Integer>> closestNodes_opt(TreeNode root, List<Integer> queries) {
        List<Integer> nodeVals = new ArrayList<>();

        inOrder(nodeVals, root);

        List<List<Integer>> ans = new ArrayList<>();
        for (int target : queries) {
            int min = binarySearchMin(nodeVals, target);
            int max = binarySearchMax(nodeVals, target);

            ans.add(new ArrayList<>(List.of(min, max)));
        }

        return ans;
    }

    private static void inOrder(List<Integer> nodeValsList, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nodeValsList);
        nodeValsList.add(root.val);
        inOrder(root.right, nodeValsList);
    }

    private static int binarySearchLeft(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        if (list.get(left) > target) {
            return -1;
        }

        if (list.get(right) <= target) {
            return list.get(right);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return list.get(left);
    }

    private static int binarySearchRight(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        if (list.get(left) >= target) {
            return list.get(left);
        }

        if (list.get(right) < target) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return list.get(left);
    }


    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{4, null, 9});
        List<Integer> q1 = new ArrayList<>();
        q1.add(3);
        System.out.println(" " + closestNodes(tst1, q1));
        System.out.println(" " + closestNodes_opt(tst1, q1));


        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14});
        List<Integer> q2 = new ArrayList<>();
        q2.add(2);
        q2.add(5);
        q2.add(16);
        System.out.println(" " + closestNodes(tst2, q2));
        System.out.println(" " + closestNodes_opt(tst2, q2));
    }
}
