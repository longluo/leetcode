package com.longluo.contest.biweekly_contest_81;

/**
 * https://leetcode.cn/contest/biweekly-contest-81/problems/maximum-xor-after-operations/
 */
public class Problem3 {

    // BF time: O(32*n) space: O(n)
    public static int maximumXOR(int[] nums) {
        int len = nums.length;

        int[][] bits = new int[len][32];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[i][j] = ((0x01 << j) & nums[i]) > 0 ? 1 : 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                cnt += bits[j][i];
            }

            if (cnt > 0) {
                ans += 0x01 << i;
            }
        }

        return ans;
    }

    //
    public static int maximumXOR_or(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans = ans | x;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + maximumXOR(new int[]{3, 2, 4, 6}));
        System.out.println("11 ?= " + maximumXOR(new int[]{1, 2, 3, 9, 2}));
        System.out.println("11 ?= " + maximumXOR_or(new int[]{1, 2, 3, 9, 2}));
    }
}
