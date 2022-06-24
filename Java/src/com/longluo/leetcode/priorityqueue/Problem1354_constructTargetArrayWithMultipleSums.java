package com.longluo.leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1354. 多次求和构造目标数组
 * <p>
 * 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
 * <p>
 * 令 x 为你数组里所有元素的和
 * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
 * 你可以重复该过程任意次
 * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
 * <p>
 * 示例 1：
 * 输入：target = [9,3,5]
 * 输出：true
 * 解释：从 [1, 1, 1] 开始
 * [1, 1, 1], 和为 3 ，选择下标 1
 * [1, 3, 1], 和为 5， 选择下标 2
 * [1, 3, 5], 和为 9， 选择下标 0
 * [9, 3, 5] 完成
 * <p>
 * 示例 2：
 * 输入：target = [1,1,1,2]
 * 输出：false
 * 解释：不可能从 [1,1,1,1] 出发构造目标数组。
 * <p>
 * 示例 3：
 * 输入：target = [8,5]
 * 输出：true
 * <p>
 * 提示：
 * N == target.length
 * 1 <= target.length <= 5 * 10^4
 * 1 <= target[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/construct-target-array-with-multiple-sums/
 */
public class Problem1354_constructTargetArrayWithMultipleSums {

    // PQ
    // TLE
    public static boolean isPossible(int[] target) {
        int len = target.length;
        long sum = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });

        for (long x : target) {
            sum += x;
            pq.offer(x);
        }

        while (!pq.isEmpty()) {
            long max = pq.poll();
            long replace = sum - max;
            if (replace < 1) {
                return false;
            }

            pq.offer(max - replace);
            sum = max;
            if (sum == len) {
                break;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPossible(new int[]{9, 3, 5}));
    }
}
