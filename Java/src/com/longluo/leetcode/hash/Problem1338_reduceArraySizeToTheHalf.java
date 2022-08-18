package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 1338. 数组大小减半
 * <p>
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * <p>
 * 示例 1：
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * <p>
 * 示例 2：
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 * <p>
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class Problem1338_reduceArraySizeToTheHalf {

    // HashMap + PQ time: O(nlogn) space: O(n)
    // TLE
    public static int minSetSize(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1] - pair1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int ans = len / 2;
        for (int i = 1; i <= len / 2; i++) {
            List<int[]> back = new ArrayList<>();
            int count = 0;
            int j = i;
            while (j > 0 && !pq.isEmpty()) {
                int[] cur = pq.poll();
                count += cur[1];
                back.add(cur);
                j--;
            }

            if (count >= len / 2) {
                ans = i;
                break;
            }

            for (int[] cur : back) {
                pq.offer(cur);
            }
        }

        return ans;
    }

    // HashMap + PQ time: O(nlogn) space: O(n)
    // AC
    public static int minSetSize_opt(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1] - pair1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int ans = len / 2;
        int count = 0;
        for (int i = 1; i <= len / 2; i++) {
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                count += cur[1];
            }

            if (count >= len / 2) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println("2 ?= " + minSetSize_opt(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }
}
