package com.longluo.contest.weekly_contest_351;

/**
 * https://leetcode.cn/contest/weekly-contest-351
 */
public class Problem1 {

    public static int countBeautifulPairs(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int first = String.valueOf(nums[i]).charAt(0) - '0';
                int last = nums[j] % 10;

                if (gcd(first, last) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + countBeautifulPairs(new int[]{2, 5, 1, 4}));
        System.out.println("2 ?= " + countBeautifulPairs(new int[]{11, 21, 12}));
    }
}
