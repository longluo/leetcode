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
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
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

    // PQ Opt time: O(nlogk) space: O(k)
    public static int findKthLargest_pq_opt(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    // QuickSelect time: O(n) space: O(1)
    public final static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest_quick(int[] nums, int k) {
        int len = nums.length;

        int target = len - k;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                // pivotIndex > target
                right = pivotIndex - 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);

        swap(nums, left, randomIndex);

        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        return ge;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("4 ?= " + findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        System.out.println("5 ?= " + findKthLargest_pq(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("4 ?= " + findKthLargest_pq(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        System.out.println("5 ?= " + findKthLargest_pq_opt(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("4 ?= " + findKthLargest_pq_opt(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        System.out.println("4 ?= " + findKthLargest_quick(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
