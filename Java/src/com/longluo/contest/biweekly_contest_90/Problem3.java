package com.longluo.contest.biweekly_contest_90;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.cn/problems/destroy-sequential-targets/
 */
public class Problem3 {

    // BF time: O(n^2+n) space: O(n)
    // TLE
    public static int destroyTargets(int[] nums, int space) {
        int len = nums.length;

        int max = nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            max = Math.max(max, x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int ans = nums[0];

        int maxTarget = 1;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; nums[i] + j * space <= max; j++) {
                int loc = nums[i] + j * space;
                cnt += map.getOrDefault(loc, 0);
            }

            if (cnt > maxTarget) {
                ans = nums[i];
                maxTarget = cnt;
            } else if (cnt == maxTarget) {
                ans = Math.min(ans, nums[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + destroyTargets(new int[]{3, 7, 8, 1, 1, 5}, 2));
        System.out.println("2 ?= " + destroyTargets(new int[]{1, 5, 3, 2, 2}, 10000));
        System.out.println("2 ?= " + destroyTargets(new int[]{6, 2, 5}, 100));
    }
}
