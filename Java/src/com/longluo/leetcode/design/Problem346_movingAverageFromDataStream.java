package com.longluo.leetcode.design;

import java.util.*;

/**
 * 346. 滑动窗口的平均值
 * <p>
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * 示例：
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * <p>
 * 提示：
 * 1 <= size <= 1000
 * -10^5 <= val <= 10^5
 * 最多调用 next 方法 10^4 次
 * <p>
 * https://leetcode.cn/problems/qIsx9U/
 */
public class Problem346_movingAverageFromDataStream {

    // List time: O(n) space: O(n)
    static class MovingAverage_list {
        List<Integer> numsList;
        int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage_list(int size) {
            numsList = new ArrayList<>();
            this.size = size;
        }

        public double next(int val) {
            numsList.add(val);
            if (numsList.size() < size) {
                return sum(0) / numsList.size();
            } else {
                return sum(numsList.size() - size) / size;
            }
        }

        private double sum(int start) {
            double sum = 0;
            for (int i = start; i < numsList.size(); i++) {
                sum += numsList.get(i);
            }

            return sum;
        }
    }

    // Queue time: O(n) space: O(size)
    static class MovingAverage_queue {
        Queue<Integer> queue;
        int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage_queue(int size) {
            queue = new ArrayDeque<>();
            this.size = size;
        }

        public double next(int val) {
            queue.add(val);
            double sum = 0;
            for (int x : queue) {
                sum += x;
            }
            if (queue.size() <= size) {
                return sum / queue.size();
            } else {
                sum -= queue.poll();
                return sum / size;
            }
        }
    }

    // Queue Opt
    static class MovingAverage_queue_opt {
        Queue<Integer> queue;
        int size = 0;
        double sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage_queue_opt(int size) {
            queue = new ArrayDeque<>();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                queue.poll();
            }

            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    public static void main(String[] args) {
        MovingAverage_list ma1 = new MovingAverage_list(3);
        System.out.println(ma1.next(12009));
        System.out.println(ma1.next(1965));
        System.out.println(ma1.next(-940));

        MovingAverage_queue_opt ma2 = new MovingAverage_queue_opt(3);
        ma2.next(12000);
    }
}
