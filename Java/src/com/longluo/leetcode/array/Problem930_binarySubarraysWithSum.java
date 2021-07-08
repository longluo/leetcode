package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * <p>
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * <p>
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class Problem930_binarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == goal) {
                    ans++;
                } else if (sum > goal) {
                    break;
                }
            }
        }

        return ans;
    }

    public static int numSubarraysWithSum_win(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int sum1 = 0;
        int sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }

        return ret;
    }

    public static int numSubarraysWithSum_pre(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSum[j] - preSum[i] == goal) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int numSubarraysWithSum_prehash(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int count = map.getOrDefault(preSum[i] - goal, 0);
            ans += count;
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println("4 ?= " + numSubarraysWithSum_win(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println("4 ?= " + numSubarraysWithSum_pre(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println("4 ?= " + numSubarraysWithSum_prehash(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println("15 ?= " + numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("15 ?= " + numSubarraysWithSum_win(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("15 ?= " + numSubarraysWithSum_pre(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("15 ?= " + numSubarraysWithSum_prehash(new int[]{0, 0, 0, 0, 0}, 0));
    }
}

