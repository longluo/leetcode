package com.longluo.leetcode.stack;

/**
 * 581. 最短无序连续子数组
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class Problem581_shortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return n;
            } else {
                return 0;
            }
        }

        int ans = 0;
        int begin = 0;
        int end = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                begin = i;
                break;
            }
        }

        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                end = i;
                break;
            }
        }

        if (end - begin < 1) {
            return 0;
        } else {
            ans = end - begin + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + findUnsortedSubarray(new int[]{1}));
        System.out.println("2 ?= " + findUnsortedSubarray(new int[]{2, 1}));
        System.out.println("5 ?= " + findUnsortedSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println("5 ?= " + findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println("0 ?= " + findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }
}
