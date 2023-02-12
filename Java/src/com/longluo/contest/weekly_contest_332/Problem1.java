package com.longluo.contest.weekly_contest_332;

/**
 * https://leetcode.cn/contest/weekly-contest-332
 */
public class Problem1 {

    public static long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        long ans = 0;

        while (left <= right) {
            if (left == right) {
                ans += nums[left];
                break;
            }

            String step = nums[left] + "" + nums[right];
            int cur = Integer.parseInt(step);
            ans += cur;
            left++;
            right--;
        }

        return ans;
    }

    public static long findTheArrayConcVal_opt(int[] nums) {
        long ans = 0;

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i == j) {
                ans += nums[i];
            } else {
                String numStr = nums[i] + "" + nums[j];
                ans += Integer.parseInt(numStr);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("596 ?= " + findTheArrayConcVal(new int[]{7, 52, 2, 4}));
        System.out.println("673 ?= " + findTheArrayConcVal(new int[]{5, 14, 13, 8, 12}));
    }
}
