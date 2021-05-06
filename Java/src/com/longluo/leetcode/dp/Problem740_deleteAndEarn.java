package com.longluo.leetcode.dp;

/**
 * 740. 删除并获得点数
 * <p>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i]，删除它并获得 nums[i] 的点数。之后，
 * 你必须删除每个等于 nums[i] - 1或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除3获得3个点数，接着要删除两个2和4。
 * 之后，再次删除3获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/delete-and-earn/
 */
public class Problem740_deleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(nums[i], maxVal);
        }

        int[] sums = new int[maxVal + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]]++;
        }

        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = sums[1];
        for (int i = 2; i < maxVal + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * sums[i]);
        }

        return dp[maxVal];
    }

    public static int deleteAndEarn_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(nums[i], maxVal);
        }

        int[] sums = new int[maxVal + 1];
        for (int num : nums) {
            sums[num] += num;
        }

        return rob(sums);
    }

    public static int rob(int[] sums) {
        int first = sums[0];
        int second = Math.max(sums[0], sums[1]);
        for (int i = 2; i < sums.length; i++) {
            int temp = second;
            second = Math.max(second, first + sums[i]);
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + deleteAndEarn(new int[]{0}));
        System.out.println("0 ?= " + deleteAndEarn_2(new int[]{0}));
        System.out.println("1 ?= " + deleteAndEarn(new int[]{1}));
        System.out.println("1 ?= " + deleteAndEarn_2(new int[]{1}));
        System.out.println("6 ?= " + deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println("6 ?= " + deleteAndEarn_2(new int[]{3, 4, 2}));
        System.out.println("9 ?= " + deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println("9 ?= " + deleteAndEarn_2(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println("4 ?= " + deleteAndEarn(new int[]{3, 1}));
        System.out.println("4 ?= " + deleteAndEarn_2(new int[]{3, 1}));
    }
}
