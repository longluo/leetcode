package com.longluo.contest.weekly_contest_292;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    static int cnt = 0;

    public static int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return cnt;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> nodeList = new ArrayList<>();
        sumOfTree(root, nodeList);
        int sum = 0;
        for (int val : nodeList) {
            sum += val;
        }

        if (sum / nodeList.size() == root.val) {
            cnt++;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public static void sumOfTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        sumOfTree(root.left, list);
        sumOfTree(root.right, list);
    }

    public static void main(String[] args) {

    }
}
