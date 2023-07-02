package com.longluo.contest.weekly_contest_352;

/**
 * https://leetcode.cn/contest/weekly-contest-352
 */
public class Problem1 {

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }

            for (int j = i; j < n; j++) {
                if (nums[j] > threshold) {
                    break;
                }

                if (check(nums, i, j, threshold)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private static boolean check(int[] nums, int left, int right, int threshold) {
        boolean flag = true;

        for (int i = left; i < right; i++) {
            if (nums[i] > threshold || nums[i] % 2 == nums[i + 1] % 2) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
        System.out.println("1 ?= " + longestAlternatingSubarray(new int[]{1, 2}, 2));
    }
}
