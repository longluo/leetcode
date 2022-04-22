package com.longluo.leetcode.array;

/**
 * 396. 旋转函数
 * <p>
 * 给定一个长度为 n 的整数数组 nums 。
 * <p>
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 * <p>
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 * <p>
 * 生成的测试用例让答案P符合 32 位 整数。
 * <p>
 * 示例 1:
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * <p>
 * 示例 2:
 * 输入: nums = [100]
 * 输出: 0
 * <p>
 * 提示:
 * n == nums.length
 * 1 <= n <= 105
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode-cn.com/problems/rotate-function/
 */
public class Problem396_rotateFunction {

    // BF time: O(n^2) space: O(1)
    public static int maxRotateFunction(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += j * nums[(j + len - i) % len];
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    // DP time: O(n) space: O(n)
    public static int maxRotateFunction_dp(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            dp[0] += i * nums[i];
            sum += nums[i];
        }

        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + sum - len * nums[(len - i) % len];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // DP Opt time: O(n) space: O(1)
    public static int maxRotateFunction_dp_opt(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            ans += i * nums[i];
            sum += nums[i];
        }

        int pre = ans;
        for (int i = 1; i < len; i++) {
            int curr = pre + sum - len * nums[len - i];
            ans = Math.max(ans, curr);
            pre = curr;
        }

        return ans;
    }

    // Prefix Sum + Win Opt time: O(n) space: O(1)
    public static int maxRotateFunction_prefix_win(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int[] sum = new int[2 * len + 1];
        for (int i = 1; i <= 2 * len; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % len];
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += i * nums[i];
        }

        int curr = ans;
        for (int i = len + 1; i < 2 * len; i++) {
            curr += nums[(i - 1) % len] * (len - 1);
            curr -= sum[i - 1] - sum[i - len];
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("26 ?= " + maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println("26 ?= " + maxRotateFunction_dp(new int[]{4, 3, 2, 6}));
        System.out.println("26 ?= " + maxRotateFunction_dp_opt(new int[]{4, 3, 2, 6}));
        System.out.println("330 ?= " + maxRotateFunction_dp_opt(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println("26 ?= " + maxRotateFunction_prefix_win(new int[]{4, 3, 2, 6}));
        System.out.println("330 ?= " + maxRotateFunction_prefix_win(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
