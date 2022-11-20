package com.longluo.contest.weekly_contest_320;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-320
 */
public class Problem1 {

    public static int unequalTriplets(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                }

                for (int k = j + 1; k < len; k++) {
                    if (nums[k] == nums[j]) {
                        continue;
                    }

                    if (nums[i] != nums[j] && nums[j] != nums[k]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }


    public static int unequalTriplets_opt(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == nums[j]) {
                        continue;
                    }

                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(" ");
    }
}
