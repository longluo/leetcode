package com.longluo.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题 17.14. 最小K个数
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class Interview_17_14_smallestKLcci {

    public static int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }

        int n = arr.length;
        if (k >= n) {
            return arr;
        }

        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public static int[] smallestK_pq(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }

        int n = arr.length;
        if (k >= n) {
            return arr;
        }

        int[] ans = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }

        int idx = 0;
        while (idx < k && !priorityQueue.isEmpty()) {
            ans[idx++] = priorityQueue.poll().intValue();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + Arrays.toString(smallestK(new int[]{}, 1)));
        System.out.println("[] ?= " + Arrays.toString(smallestK(new int[]{1}, 0)));
        System.out.println("[1] ?= " + Arrays.toString(smallestK(new int[]{1, 2}, 1)));
        System.out.println("[] ?= " + Arrays.toString(smallestK(new int[]{1, 2}, 0)));
        System.out.println("[1, 2, 3, 4] ?= " + Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
        System.out.println("[1, 2, 3, 4] ?= " + Arrays.toString(smallestK_pq(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
