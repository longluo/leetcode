package com.longluo.contest.weekly_contest_334;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-334
 */
public class Problem1 {

    public static int[] leftRigthDifference(int[] nums) {
        int len = nums.length;

        int[] leftSum = new int[len];
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        int[] rightSum = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[0] ?= " + Arrays.toString(leftRigthDifference(new int[]{1})));
        System.out.println("[15, 1, 11, 22] ?= " + Arrays.toString(leftRigthDifference(new int[]{10, 4, 8, 3})));
    }
}
