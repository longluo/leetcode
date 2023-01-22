package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1815. 得到新鲜甜甜圈的最多组数
 * <p>
 * 有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，
 * 之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整数 batchSize 和一个整数数组 groups ，
 * 数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
 * <p>
 * 当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。
 * 如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
 * <p>
 * 你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
 * <p>
 * 示例 1：
 * 输入：batchSize = 3, groups = [1,2,3,4,5,6]
 * 输出：4
 * 解释：你可以将这些批次的顾客顺序安排为 [6,2,4,5,1,3] 。那么第 1，2，4，6 组都会感到开心。
 * <p>
 * 示例 2：
 * 输入：batchSize = 4, groups = [1,3,2,5,2,2,1,6]
 * 输出：4
 * <p>
 * 提示：
 * 1 <= batchSize <= 9
 * 1 <= groups.length <= 30
 * 1 <= groups[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/
 */
public class Problem1815_maximumNumberofGroupsGettingFreshDonuts {

    // Backtracking time: O(n!) space: O(n!)
    // MLE
    public static int maxHappyGroups(int batchSize, int[] groups) {
        int len = groups.length;

        for (int i = 0; i < len; i++) {
            groups[i] = groups[i] % batchSize;
        }

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), new boolean[len], groups);

        int ans = 0;

        for (List<Integer> item : res) {
            int remain = 0;
            int happy = 0;
            for (int x : item) {
                if (remain == 0) {
                    happy++;
                }

                if (remain >= x) {
                    remain -= x;
                } else {
                    remain = batchSize + remain - x;
                }
            }

            ans = Math.max(ans, happy);
        }

        return ans;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, boolean[] visited, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            backtrack(res, path, visited, nums);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }


    // Backtracking time: O(n!) space: O(n!)
    // TLE
    static int maxHappy = 0;

    public static int maxHappyGroups_opt(int batchSize, int[] groups) {
        maxHappy = 0;

        int len = groups.length;

        for (int i = 0; i < len; i++) {
            groups[i] = groups[i] % batchSize;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[len];

        backtrack(path, visited, groups, batchSize);

        return maxHappy;
    }

    private static void backtrack(List<Integer> path, boolean[] visited, int[] nums, int batchSize) {
        if (path.size() == nums.length) {
            int remain = 0;
            int happy = 0;

            for (int x : path) {
                if (remain == 0) {
                    happy++;
                }

                if (remain >= x) {
                    remain -= x;
                } else {
                    remain = batchSize + remain - x;
                }
            }

            maxHappy = Math.max(maxHappy, happy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            backtrack(path, visited, nums, batchSize);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println("4 ?= " + maxHappyGroups(3, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("4 ?= " + maxHappyGroups(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}));

        System.out.println("4 ?= " + maxHappyGroups_opt(3, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("4 ?= " + maxHappyGroups_opt(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}));
    }
}
