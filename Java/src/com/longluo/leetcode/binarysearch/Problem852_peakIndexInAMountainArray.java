package com.longluo.leetcode.binarysearch;

/**
 * 852. 山脉数组的峰顶索引
 * <p>
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * 提示：
 * 3 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^6
 * 题目数据保证 arr 是一个山脉数组
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class Problem852_peakIndexInAMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return 0;
    }

    public static int peakIndexInMountainArray_bs(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                begin = mid;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                end = mid;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println("1 ?= " + peakIndexInMountainArray_bs(new int[]{0, 1, 0}));
        System.out.println("1 ?= " + peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println("1 ?= " + peakIndexInMountainArray_bs(new int[]{0, 2, 1, 0}));
        System.out.println("1 ?= " + peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println("1 ?= " + peakIndexInMountainArray_bs(new int[]{0, 10, 5, 2}));
        System.out.println("2 ?= " + peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println("2 ?= " + peakIndexInMountainArray_bs(new int[]{3, 4, 5, 1}));
        System.out.println("2 ?= " + peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println("2 ?= " + peakIndexInMountainArray_bs(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println("5 ?= " + peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
        System.out.println("5 ?= " + peakIndexInMountainArray_bs(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }
}
