package com.longluo.leetcode.dp;

/**
 * 213. 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Problem213_houseRobber_ii {

    // Use DP O(n) O(n)
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp_1 = new int[len];
        int[] dp_2 = new int[len];

        dp_1[0] = nums[0];
        dp_1[1] = Math.max(nums[0], nums[1]);

        dp_2[0] = nums[1];
        dp_2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < len - 1; i++) {
            dp_1[i] = Math.max(dp_1[i - 1], dp_1[i - 2] + nums[i]);
        }

        for (int j = 3; j < len; j++) {
            dp_2[j - 1] = Math.max(dp_2[j - 2], dp_2[j - 3] + nums[j]);
        }

        return Math.max(dp_1[len - 2], dp_2[len - 2]);
    }

    // Use DP Opt  O(n) O(1)
    public static int rob_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int len = nums.length;
        return Math.max(robRange(nums, 0, len - 1), robRange(nums, 1, len));
    }

    public static int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + rob(new int[]{1, 2, 3, 1}));
        System.out.println("3 ?= " + rob(new int[]{2, 3, 2}));
        System.out.println("0 ?= " + rob(new int[]{0, 0}));

        System.out.println("4 ?= " + rob_2(new int[]{1, 2, 3, 1}));
        System.out.println("3 ?= " + rob_2(new int[]{2, 3, 2}));
        System.out.println("0 ?= " + rob_2(new int[]{0, 0}));
    }
}
