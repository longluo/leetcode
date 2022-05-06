package com.longluo.top100;

import java.util.*;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Problem215_kthLargestElementInAnArray {

    // Sort time: O(nlogn) space: O(logn)
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    // PQ time: O(nlogn) space: O(n)
    public static int findKthLargest_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int x : nums) {
            pq.offer(x);
        }

        int ans = 0;
        while (k > 0 && !pq.isEmpty()) {
            ans = pq.poll();
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("5 ?= " + findKthLargest_pq(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("4 ?= " + findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println("4 ?= " + findKthLargest_pq(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
