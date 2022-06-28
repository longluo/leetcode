package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * <p>
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 示例 1：
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 示例 2：
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * 提示：
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 3 * 10^4
 * <p>
 * https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class Problem907_sumOfSubarrayMinimums {

    // BF time: O(n^3) space: O(1)
    // TLE
    public static int sumSubarrayMins_bf(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int min = arr[j];
                for (int k = j + 1; k <= i; k++) {
                    min = Math.min(min, arr[k]);
                }

                ans = (ans + min) % MOD;
            }
        }

        return ans;
    }

    // BF Opt time: O(n^2) space: O(1)
    // TLE
    public static int sumSubarrayMins_bf_opt(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }

        return ans;
    }

    // use minus replace MOD
    // TLE
    public static int sumSubarrayMins_bf_opt_mod(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                ans += min;
                ans = ans >= MOD ? ans - MOD : ans;
            }
        }

        return (int) ans;
    }

    // LeftRight time: O(n) space: O(n)
    public static int sumSubarrayMins_leftright(int[] arr) {
        int MOD = 1_000_000_007;

        int len = arr.length;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        right[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int idx = i - 1;
            while (idx >= 0 && arr[idx] > arr[i]) {
                idx = left[idx];
            }

            left[i] = idx;
        }

        for (int i = len - 2; i >= 0; i--) {
            int idx = i + 1;
            while (idx < len && arr[idx] >= arr[i]) {
                idx = right[idx];
            }

            right[i] = idx;
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (ans + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) ans;
    }

    // MonoStack time: O(n) space: O(n)
    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        int len = arr.length;

        Stack<Integer> stk = new Stack<>();

        long ans = 0;

        for (int i = 0; i < len; i++) {
            while (!stk.empty() && arr[i] < arr[stk.peek()]) {
                int curr = stk.pop();

                int prevIndex = stk.isEmpty() ? -1 : stk.peek();

                int prevCnt = curr - prevIndex;
                int nextCnt = i - curr;

                ans += (long) arr[curr] * prevCnt * nextCnt % MOD;
                ans %= MOD;
            }

            stk.push(i);
        }

        while (!stk.empty()) {
            int curr = stk.pop();

            int prevIndex = stk.isEmpty() ? -1 : stk.peek();

            int prevCnt = curr - prevIndex;
            int nextCnt = len - curr;

            ans += (long) arr[curr] * prevCnt * nextCnt % MOD;
            ans %= MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println("17 ?= " + sumSubarrayMins_bf(new int[]{3, 1, 2, 4}));

        System.out.println("17 ?= " + sumSubarrayMins_bf_opt(new int[]{3, 1, 2, 4}));
        System.out.println("17 ?= " + sumSubarrayMins_bf_opt_mod(new int[]{3, 1, 2, 4}));

        System.out.println("17 ?= " + sumSubarrayMins_leftright(new int[]{3, 1, 2, 4}));
        System.out.println("593 ?= " + sumSubarrayMins_leftright(new int[]{71, 55, 82, 55}));

        System.out.println("17 ?= " + sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println("40 ?= " + sumSubarrayMins(new int[]{3, 4, 5, 6}));
        System.out.println("593 ?= " + sumSubarrayMins(new int[]{71, 55, 82, 55}));
    }
}
