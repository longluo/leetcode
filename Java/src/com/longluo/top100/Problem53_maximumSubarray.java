package com.longluo.top100;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Problem53_maximumSubarray {

    // BF time: O(n^2) space: O(1)
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    // DP time: O(n) space: O(n)
    public static int maxSubArray_dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // DP Opt time: O(n) space: O(1)
    public static int maxSubArray_dp_opt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }

        return ans;
    }

    // Divide and Comquer
    public static class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public static int maxSubArray_3(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public static Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public static Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


    public static void main(String[] args) {
        System.out.println("1 ?= " + maxSubArray(new int[]{1}));
        System.out.println("0 ?= " + maxSubArray(new int[]{0}));
        System.out.println("-1 ?= " + maxSubArray(new int[]{-1}));
        System.out.println("-1000 ?= " + maxSubArray(new int[]{-1000}));
        System.out.println("6 ?= " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println("6 ?= " + maxSubArray_dp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("-1 ?= " + maxSubArray_dp(new int[]{-1, -2}));

        System.out.println("6 ?= " + maxSubArray_dp_opt(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

