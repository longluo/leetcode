package com.longluo.top100;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Problem239_slidingWindowMaximum {

    // BF time: O(k*n) space: O(1)
    // TimeOut
    public static int[] maxSlidingWindow_bf(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            ans[i] = max;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1] ?= " + Arrays.toString(maxSlidingWindow_bf(new int[]{1}, 1)));
        System.out.println("[3,3,5,5,6,7] ?= " + Arrays.toString(maxSlidingWindow_bf(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
