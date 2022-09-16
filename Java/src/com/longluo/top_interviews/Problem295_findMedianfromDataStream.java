package com.longluo.top_interviews;

import java.util.*;

/**
 * 295. 数据流的中位数
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * 进阶:
 * 如果数据流中所有整数都在0到100范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * https://leetcode.cn/problems/find-median-from-data-stream/
 */
public class Problem295_findMedianfromDataStream {

    // BF time: O(nlogn) space: O(n)
    static class MedianFinder {
        List<Integer> nums;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            nums = new ArrayList<>();
        }

        public void addNum(int num) {
            nums.add(num);
        }

        public double findMedian() {
            Collections.sort(nums);

            int len = nums.size();

            double sum = nums.get(len / 2);

            if (len % 2 == 0) {
                sum += nums.get(len / 2 - 1);
                return sum / 2;
            }

            return sum;
        }
    }

    // PriorityQueue time: O(logn) space: O(n)
    static class MedianFinder_pq {
        PriorityQueue<Integer> queueMin;
        PriorityQueue<Integer> queueMax;

        public MedianFinder_pq() {
            queueMin = new PriorityQueue<>((a, b) -> b - a);
            queueMax = new PriorityQueue<>(((a, b) -> a - b));
        }

        public void addNum(int num) {
            if (queueMin.isEmpty() || num <= queueMin.peek()) {
                queueMin.offer(num);

                if (queueMax.size() + 1 < queueMin.size()) {
                    queueMax.offer(queueMin.poll());
                }
            }

            if (num > queueMin.peek()) {
                queueMax.offer(num);

                if (queueMin.size() + 1 <= queueMax.size()) {
                    queueMin.offer(queueMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queueMin.size() > queueMax.size()) {
                return queueMin.peek();
            }

            return (queueMin.peek() + queueMax.peek()) / 2.0;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public static void main(String[] args) {
        MedianFinder tst1 = new MedianFinder();
        tst1.addNum(2);
        tst1.addNum(3);
        System.out.println(tst1.findMedian());
        tst1.addNum(5);
        System.out.println(tst1.findMedian());

        MedianFinder_pq tst2 = new MedianFinder_pq();
        tst2.addNum(1);
        tst2.addNum(2);
        System.out.println(tst2.findMedian());
        tst2.addNum(3);
        System.out.println(tst2.findMedian());
    }
}
