package com.longluo.contest.weekly_contest_317;

/**
 * https://leetcode.cn/contest/weekly-contest-317/
 */

/**
 * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 */
public class Problem1 {

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
