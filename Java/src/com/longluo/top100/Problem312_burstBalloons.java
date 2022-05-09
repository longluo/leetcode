package com.longluo.top100;

/**
 * 312. 戳气球
 * <p>
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * <p>
 * 示例 2：
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/burst-balloons/
 */
public class Problem312_burstBalloons {

    // DP time: O(n^3) space: O(n^2)
    public static int maxCoins_dp(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] balloons = new int[len + 2];
        balloons[0] = 1;
        balloons[len + 1] = 1;
        System.arraycopy(nums, 0, balloons, 1, len);

        int[][] dp = new int[len + 2][len + 2];
        for (int range = 3; range <= len + 2; range++) {
            for (int i = 0; i <= len + 2 - range; i++) {
                int res = 0;
                for (int k = i + 1; k < i + range - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + range - 1];
                    res = Math.max(res, left + right + balloons[i] * balloons[k] * balloons[i + range - 1]);
                }

                dp[i][i + range - 1] = res;
            }
        }

        return dp[0][len + 1];
    }

    // TODO: 2022/5/9 Recursion 
    
    public static void main(String[] args) {
        System.out.println("167 ?= " + maxCoins_dp(new int[]{3, 1, 5, 8}));
        System.out.println("10 ?= " + maxCoins_dp(new int[]{1, 5}));
    }
}
