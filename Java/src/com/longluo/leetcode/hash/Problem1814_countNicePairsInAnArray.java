package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * <p>
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。
 * <p>
 * 比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * <p>
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10^9 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * <p>
 * 示例 2：
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 */
public class Problem1814_countNicePairsInAnArray {

    // HashMap time: O(n^2) space: O(n)
    // TLE
    public static int countNicePairs(int[] nums) {
        int MOD = 1_000_000_007;

        Map<Integer, Integer> revMap = new HashMap<>();

        for (int x : nums) {
            revMap.put(x, reverse(x));
        }

        int ans = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + revMap.get(nums[j])) == (nums[j] + revMap.get(nums[i]))) {
                    ans++;
                    ans %= MOD;
                }
            }
        }

        return ans;
    }

    // HashMap + Math time: O(n) space: O(n)
    public static int countNicePairs_opt(int[] nums) {
        int MOD = 1_000_000_007;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : nums) {
            int diff = x - reverse(x);
            countMap.put(diff, countMap.getOrDefault(diff, 0) + 1);
        }

        long ans = 0;
        for (int x : countMap.values()) {
            long comb = (long) x * (x - 1) / 2;
            ans += comb;
            ans %= MOD;
        }

        return (int) ans;
    }

    private static int reverse(int num) {
        int ans = 0;

        while (num > 0) {
            ans = 10 * ans + num % 10;
            num /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println("4 ?= " + countNicePairs(new int[]{13, 10, 35, 24, 76}));

        System.out.println("2 ?= " + countNicePairs_opt(new int[]{42, 11, 1, 97}));
        System.out.println("4 ?= " + countNicePairs_opt(new int[]{13, 10, 35, 24, 76}));
    }
}
