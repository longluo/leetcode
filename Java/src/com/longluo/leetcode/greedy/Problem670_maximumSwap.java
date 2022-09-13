package com.longluo.leetcode.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 670. 最大交换
 * <p>
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * <p>
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * <p>
 * 注意:
 * 给定数字的范围是 [0, 10^8]
 * <p>
 * https://leetcode.cn/problems/maximum-swap/
 */
public class Problem670_maximumSwap {

    // BF time: O(n^2) space: O(n)
    public static int maximumSwap_bf(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int maxNum = num;
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(digits, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(digits)));
                swap(digits, j, i);
            }
        }

        return maxNum;
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Greedy time: O(n) space: O(n)
    public static int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int len = digits.length;
        int maxIdx = len - 1;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i;
            } else if (digits[i] < digits[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }

        if (idx1 < idx2) {
            char temp = digits[idx1];
            digits[idx1] = digits[idx2];
            digits[idx2] = temp;
            return Integer.parseInt(new String(digits));
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println("9973 ?= " + maximumSwap_bf(9973));
        System.out.println("98863 ?= " + maximumSwap_bf(98368));
        System.out.println("90909011 ?= " + maximumSwap_bf(10909091));

        System.out.println("7236 ?= " + maximumSwap(2736));
        System.out.println("9973 ?= " + maximumSwap(9973));
        System.out.println("9913 ?= " + maximumSwap(1993));
        System.out.println("511 ?= " + maximumSwap(115));
        System.out.println("90909011 ?= " + maximumSwap(10909091));
        System.out.println("91909021 ?= " + maximumSwap(21909091));
        System.out.println("98863 ?= " + maximumSwap(98368));
    }
}
