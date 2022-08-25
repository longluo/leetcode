package com.longluo.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * <p>
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * <p>
 * 提示：
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10^4
 * arr 按 升序 排列
 * -10^4 <= arr[i], x <= 10^4
 * <p>
 * https://leetcode.cn/problems/find-k-closest-elements/
 */
public class Problem658_findKClosestElements {

    // BF time: O(n) space: O(1)
    public static List<Integer> findClosestElements_bf(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int len = arr.length;
        int targetPos = -1;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (Math.abs(arr[i] - x) < delta) {
                delta = Math.abs(arr[i] - x);
                targetPos = i;
            }
        }

        ans.add(arr[targetPos]);
        k--;

        int left = targetPos - 1;
        int right = targetPos + 1;
        while (k > 0) {
            if (left >= 0 && right < len && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                ans.add(arr[left]);
                left--;
                k--;
            } else if (left >= 0 && right < len && Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                ans.add(arr[right]);
                right++;
                k--;
            } else if (left >= 0 && right == len) {
                ans.add(arr[left]);
                left--;
                k--;
            } else if (left < 0 && right < len) {
                ans.add(arr[right]);
                right++;
                k--;
            }
        }

        Collections.sort(ans);

        return ans;
    }

    // BinarySearch time: O(n) space: O(1)
    public static List<Integer> findClosestElements_bs(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int len = arr.length;
        int targetPos = binarySearch(arr, x);
        ans.add(arr[targetPos]);
        k--;

        int left = targetPos - 1;
        int right = targetPos + 1;
        while (k > 0) {
            if (left >= 0 && right < len && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                ans.add(arr[left]);
                left--;
                k--;
            } else if (left >= 0 && right < len && Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                ans.add(arr[right]);
                right++;
                k--;
            } else if (left >= 0 && right == len) {
                ans.add(arr[left]);
                left--;
                k--;
            } else if (left < 0 && right < len) {
                ans.add(arr[right]);
                right++;
                k--;
            }
        }

        Collections.sort(ans);

        return ans;
    }

    private static int binarySearch(int[] arr, int target) {
        int len = arr.length;
        if (arr[0] >= target) {
            return 0;
        } else if (arr[len - 1] <= target) {
            return len - 1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (Math.abs(arr[left] - target) <= Math.abs(arr[left + 1] - target)) {
            return left;
        } else {
            return left + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("[1,2,3,4] ?= " + findClosestElements_bf(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println("[1,2,3,4] ?= " + findClosestElements_bf(new int[]{1, 2, 3, 4, 5}, 4, -1));

        System.out.println("[1,2,3,4] ?= " + findClosestElements_bs(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println("[1,2,3,4] ?= " + findClosestElements_bs(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println("[10] ?= " + findClosestElements_bs(new int[]{1, 1, 10, 10, 10}, 1, 9));
    }
}
