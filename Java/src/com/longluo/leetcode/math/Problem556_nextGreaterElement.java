package com.longluo.leetcode.math;

import java.util.Arrays;

/**
 * 556. 下一个更大元素 III
 * <p>
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
 * 如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：21
 * <p>
 * 示例 2：
 * 输入：n = 21
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/next-greater-element-iii/
 */
public class Problem556_nextGreaterElement {

    public static int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }

        char[] array = String.valueOf(n).toCharArray();
        int len = array.length;
        int left = len - 2;
        while (left >= 0 && array[left] >= array[left + 1]) {
            left--;
        }
        if (left < 0) {
            return -1;
        }
        int right = len - 1;
        while (right > left && array[right] <= array[left]) {
            right--;
        }
        swap(array, left, right);
        reverse(array, left + 1, len - 1);
        long res = Long.parseLong(new String(array));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) res;
    }

    public static void reverse(char[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println("21 ?= " + nextGreaterElement(12));
        System.out.println("-1 ?= " + nextGreaterElement(1));
        System.out.println("-1 ?= " + nextGreaterElement(10));
        System.out.println("-1 ?= " + nextGreaterElement(55));
        System.out.println("-1 ?= " + nextGreaterElement(21));
        System.out.println("132 ?= " + nextGreaterElement(123));
        System.out.println("213 ?= " + nextGreaterElement(132));
        System.out.println("230412 ?= " + nextGreaterElement(230241));
        System.out.println("13222344 ?= " + nextGreaterElement(12443322));
    }
}
