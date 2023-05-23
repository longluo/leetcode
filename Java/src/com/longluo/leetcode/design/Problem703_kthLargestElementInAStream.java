package com.longluo.leetcode.design;

import java.util.*;

/**
 * 703. 数据流中的第 K 大元素
 * <p>
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * 提示：
 * 1 <= k <= 10^4
 * 0 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * -10^4 <= val <= 10^4
 * 最多调用 add 方法 10^4 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 */
public class Problem703_kthLargestElementInAStream {

    // BF ArrayList time: O(nlogn) space: O(n)
    static class KthLargest {
        List<Integer> numList;
        int kLargest;

        public KthLargest(int k, int[] nums) {
            numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }

            kLargest = k;
        }

        public int add(int val) {
            numList.add(val);
            Collections.sort(numList);
            return numList.get(numList.size() - kLargest);
        }
    }

    // Heap time: O(nlogk) space: O(k)
    static class KthLargest_Heap {
        PriorityQueue<Integer> pq;
        int kLargest;

        public KthLargest_Heap(int k, int[] nums) {
            kLargest = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > kLargest) {
                pq.poll();
            }

            return pq.peek();
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("4 ?= " + kthLargest.add(3));
        System.out.println("5 ?= " + kthLargest.add(5));

        KthLargest_Heap kthLargest_heap = new KthLargest_Heap(3, new int[]{4, 5, 8, 2});
        System.out.println("4 ?= " + kthLargest_heap.add(3));
        System.out.println("5 ?= " + kthLargest_heap.add(5));
    }
}
