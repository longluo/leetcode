package com.longluo.leetcode.binarysearch;

/**
 * 1539. 第 k 个缺失的正整数
 * <p>
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 * <p>
 * https://leetcode-cn.com/problems/kth-missing-positive-number/
 */
public class Problem1539_kthMissingPositiveNumber {

    // BF O(n) O(1)
    public static int findKthPositive_bf(int[] arr, int k) {
        int i = 0;
        int j = 1;
        while (i < arr.length) {
            if (arr[i] == j) {
                i++;
                j++;
            }
            while (i < arr.length && arr[i] > j) {
                if (k == 1) {
                    return j;
                }
                j++;
                k--;
            }
        }

        while (k > 1) {
            j++;
            k--;
        }

        return j;
    }

    // BF Opt O(n) O(1)
    public static int findKthPositive_bf_opt(int[] arr, int k) {
        int len = arr.length;
        int idx = 0;
        int cnt = 0;
        for (int i = 1; i < len + k; i++) {
            if (idx < len && arr[idx] == i) {
                idx++;
            } else {
                cnt++;
                if (cnt == k) {
                    return i;
                }
            }
        }

        return len + k;
    }

    // BS O(logn) O(1)
    public static int findKthPositive_bs(int[] arr, int k) {
        int len = arr.length;
        int left = 1;
        int right = len + k;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + findKthPositive_bf(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println("6 ?= " + findKthPositive_bf(new int[]{1, 2, 3, 4}, 2));

        System.out.println("9 ?= " + findKthPositive_bf_opt(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println("6 ?= " + findKthPositive_bf_opt(new int[]{1, 2, 3, 4}, 2));
    }
}
