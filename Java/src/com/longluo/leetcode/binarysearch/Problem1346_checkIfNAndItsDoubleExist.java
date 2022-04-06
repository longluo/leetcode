package com.longluo.leetcode.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1346. 检查整数及其两倍数是否存在
 * <p>
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * 示例 1：
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * <p>
 * 示例 2：
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * <p>
 * 示例 3：
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * <p>
 * 提示：
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 * <p>
 * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
 */
public class Problem1346_checkIfNAndItsDoubleExist {

    // BF time: O(n^2) space: O(1)
    public static boolean checkIfExist_bf(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Hash time: O(n) space: O(n)
    public static boolean checkIfExist_hash(int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(2 * arr[i]) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))) {
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }

    // BinarySearch time: O(nlogn) space: O(logn)
    public static boolean checkIfExist_bs(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            if (arr[i] < 0) {
                if (arr[i] % 2 == 0 && binarySearch(arr, i + 1, len - 1, arr[i] / 2)) {
                    return true;
                }
            } else if (arr[i] > 0) {
                if (binarySearch(arr, i + 1, len - 1, arr[i] * 2)) {
                    return true;
                }
            } else if (arr[i] == 0) {
                if (i + 1 < len && arr[i + 1] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return false;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    // Two Pointers time: O(nlogn) space: O(n)
    public static boolean checkIfExist_tp(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0, j = 0; i < len; i++) {
            while (j < len && arr[i] * 2 > arr[j]) {
                j++;
            }

            if (j < len && i != j && arr[i] * 2 == arr[j]) {
                return true;
            }
        }

        for (int i = len - 1, j = len - 1; i >= 0; i--) {
            while (j >= 0 && arr[i] % 2 == 0 && arr[i] / 2 > arr[j]) {
                j--;
            }

            if (j >= 0 && i != j && arr[i] % 2 == 0 && arr[i] == 2 * arr[j]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + checkIfExist_tp(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }
}
