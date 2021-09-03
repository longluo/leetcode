package com.longluo.interview;

import java.util.*;

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

    public static int[] smallestK_maxheap(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }

        int n = arr.length;
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (pq.peek() > arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    public int[] smallestK_kp(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
