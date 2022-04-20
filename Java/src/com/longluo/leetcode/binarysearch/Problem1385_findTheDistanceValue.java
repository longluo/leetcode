package com.longluo.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 * <p>
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * <p>
 * 示例 1：
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出：2
 * 解释：
 * 对于 arr1[0]=4 我们有：
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * 所以 arr1[0]=4 符合距离要求
 * <p>
 * 对于 arr1[1]=5 我们有：
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * 所以 arr1[1]=5 也符合距离要求
 * <p>
 * 对于 arr1[2]=8 我们有：
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * 存在距离小于等于 2 的情况，不符合距离要求
 * <p>
 * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 * <p>
 * 示例 2：
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出：1
 * <p>
 * 提示：
 * 1 <= arr1.length, arr2.length <= 500
 * -10^3 <= arr1[i], arr2[j] <= 10^3
 * 0 <= d <= 100
 * <p>
 * https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 */
public class Problem1385_findTheDistanceValue {

    // BF time: O(m * n) space: O(1)
    public static int findTheDistanceValue_bf(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int x : arr1) {
            boolean flag = true;
            for (int y : arr2) {

                flag &= Math.abs(x - y) > d;

//                if (Math.abs(x - y) <= d) {
//                    flag = false;
//                }
            }

//            ans = flag ? ans + 1 : ans;
            ans += flag ? 1 : 0;
        }

        return ans;
    }

    // Two Pointers  time: O(m * n) space: O(1)
    public static int findTheDistanceValue_tp(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int x : arr1) {
            int left = x - d;
            int right = x + d;
            boolean flag = true;
            for (int y : arr2) {
                if (y >= left && y <= right) {
                    flag = false;
                }
            }

            ans += flag ? 1 : 0;
        }

        return ans;
    }

    // BS time: O((m+n)logn) space: O(1)
    public static int findTheDistanceValue_bs(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int x : arr1) {
            int low = x - d;
            int high = x + d;
            if (!binarySearch(arr2, low, high)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean binarySearch(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= low && arr[mid] <= high) {
                return true;
            } else if (arr[mid] < low) {
                left = mid + 1;
            } else if (arr[mid] > high) {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findTheDistanceValue_bf(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println("2 ?= " + findTheDistanceValue_bs(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }
}
