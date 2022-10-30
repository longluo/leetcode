package com.longluo.contest.biweekly_contest_90;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-greater-element-iv/
 */
public class Problem4 {

    // BF time: O(n^2) space: O(n)
    public static int[] secondGreaterElement_bf(int[] nums) {
        int len = nums.length;

        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        for (int i = 0; i < len; i++) {
            int secondLarge = -1;
            int cnt = 0;
            boolean flag = false;

            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    cnt++;
                    secondLarge = nums[j];
                    if (cnt == 2) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                ans[i] = secondLarge;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[9, 6, 6, -1, -1] ?= " + Arrays.toString(secondGreaterElement_bf(new int[]{2, 4, 0, 9, 6})));
        System.out.println("[18, 18, -1, 10, -1, -1, -1, -1] ?= " + Arrays.toString(secondGreaterElement_bf(new int[]{1, 17, 18, 0, 18, 10, 20, 0})));
    }
}
