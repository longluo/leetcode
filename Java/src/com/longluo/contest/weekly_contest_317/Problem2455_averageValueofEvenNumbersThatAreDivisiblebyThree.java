package com.longluo.contest.weekly_contest_317;

/**
 * https://leetcode.cn/contest/weekly-contest-317/
 */

/**
 * 2455. 可被三整除的偶数的平均值
 * <p>
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * <p>
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 */
public class Problem2455_averageValueofEvenNumbersThatAreDivisiblebyThree {

    // Simulate time: O(n) space: O(1)
    public static int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;

        for (int x : nums) {
            if (x % 3 == 0 && x % 2 == 0) {
                sum += x;
                cnt++;
            }
        }

        return cnt == 0 ? 0 : sum / cnt;
    }

    // Opt x % 6 == 0
    public static int averageValue_opt(int[] nums) {
        int len = nums.length;

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] % 6 == 0) {
                sum += nums[i];
                cnt++;
            }
        }

        return cnt == 0 ? 0 : sum / cnt;
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + averageValue(new int[]{1, 3, 6, 10, 12, 15}));
        System.out.println("9 ?= " + averageValue_opt(new int[]{1, 3, 6, 10, 12, 15}));
    }
}
