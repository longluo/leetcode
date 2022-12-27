package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1799. N 次操作后的最大分数和
 * <p>
 * 给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
 * <p>
 * 在第 i 次操作时（操作编号从 1 开始），你需要：
 * <p>
 * 选择两个元素 x 和 y 。
 * 获得分数 i * gcd(x, y) 。
 * 将 x 和 y 从 nums 中删除。
 * 请你返回 n 次操作后你能获得的分数和最大为多少。
 * <p>
 * 函数 gcd(x, y) 是 x 和 y 的最大公约数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最优操作是：
 * (1 * gcd(1, 2)) = 1
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,6,8]
 * 输出：11
 * 解释：最优操作是：
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,4,5,6]
 * 输出：14
 * 解释：最优操作是：
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 * <p>
 * 提示：
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 10^6
 * <p>
 * https://leetcode.cn/problems/maximize-score-after-n-operations/
 */
public class Problem1799_maximizeScoreAfterNOperations {

    // Backtracking time: O(2^n) space: O(n)
    // TLE
    public static int maxScore_bf(int[] nums) {
        int len = nums.length;

        boolean[] visited = new boolean[len];

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, visited, 0, len / 2);

        int ans = 0;
        for (List<Integer> path : res) {

            Collections.sort(path);

            int cnt = 0;
            for (int i = 0; i < path.size(); i++) {
                cnt += (i + 1) * path.get(i);
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited, int start, int remain) {
        int len = nums.length;

        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            for (int j = 0; j < len; j++) {
                if (visited[j]) {
                    continue;
                }

                int factor = gcd(nums[i], nums[j]);
                path.add(factor);

                visited[j] = true;

                backtrack(res, path, nums, visited, i + 1, remain - 1);

                visited[j] = false;

                path.remove(path.size() - 1);
            }

            visited[i] = false;
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + maxScore_bf(new int[]{1, 2}));
        System.out.println("11 ?= " + maxScore_bf(new int[]{3, 4, 6, 8}));
        System.out.println("14 ?= " + maxScore_bf(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("60 ?= " + maxScore_bf(new int[]{171651, 546244, 880754, 412358}));
        System.out.println("869 ?= " + maxScore_bf(new int[]{697035, 181412, 384958, 575458}));
        System.out.println("154 ?= " + maxScore_bf(new int[]{925612, 737192, 813525, 707250}));
        System.out.println("782 ?= " + maxScore_bf(new int[]{39759, 619273, 859218, 228161, 944571, 597983, 483239, 179849, 868130, 909935, 912143, 817908, 738222, 653224}));
    }
}
