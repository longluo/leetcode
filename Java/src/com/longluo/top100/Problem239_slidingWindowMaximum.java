package com.longluo.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
 * https://leetcode.com/problems/sliding-window-maximum/
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

    // SlidingWin + PQ time: O(nlogk) space: O(k)
    // TLE
    public static int[] maxSlidingWindow_slidingwin(int[] nums, int k) {
        int len = nums.length;

        int[] ans = new int[len - k + 1];

        int left = 0;
        int right = k;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = left; i < right; i++) {
            pq.offer(nums[i]);
        }

        while (left <= right - k && right < len) {
            ans[left] = pq.peek();
            pq.offer(nums[right]);
            pq.remove(nums[left]);
            left++;
            right++;
        }

        ans[left] = pq.peek();

        return ans;
    }

    // TODO: 2022/5/11
    // https://leetcode.cn/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/

    public static void main(String[] args) {
        System.out.println("[1] ?= " + Arrays.toString(maxSlidingWindow_bf(new int[]{1}, 1)));
        System.out.println("[3,3,5,5,6,7] ?= " + Arrays.toString(maxSlidingWindow_bf(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        System.out.println("[3,3] ?= " + Arrays.toString(maxSlidingWindow_slidingwin(new int[]{1, 3, -1, -3}, 3)));
        System.out.println("[3,3,5,5,6,7] ?= " + Arrays.toString(maxSlidingWindow_slidingwin(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
