package com.longluo.leetcode.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * <p>
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>
 * 示例 1：
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * <p>
 * 示例 2：
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * <p>
 * 示例 3：
 * 输入：arr = [2,3]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * <p>
 * 示例 5：
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 * <p>
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 * <p>
 * https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Problem1442_countTripletsThatCanFormTwoArraysOfEqualXor {

    public static int countTriplets(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = getXorValue(arr, i, j);
                for (int k = j; k < arr.length; k++) {
                    int b = getXorValue(arr, j, k + 1);
                    if (a == b) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(k);
                        res.add(temp);
                    }
                }
            }
        }

        return res.size();
    }

    public static int getXorValue(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res = res ^ arr[i];
        }

        return res;
    }

    public static int countTriplets_2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int ans = 0;
        int n = arr.length;
        int[] xor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println("4 ?= " + countTriplets_2(new int[]{2, 3, 1, 6, 7}));
        System.out.println("10 ?= " + countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println("10 ?= " + countTriplets_2(new int[]{1, 1, 1, 1, 1}));
        System.out.println("0 ?= " + countTriplets(new int[]{2, 3}));
        System.out.println("0 ?= " + countTriplets_2(new int[]{2, 3}));
        System.out.println("3 ?= " + countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println("3 ?= " + countTriplets_2(new int[]{1, 3, 5, 7, 9}));
        System.out.println("8 ?= " + countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
        System.out.println("8 ?= " + countTriplets_2(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}
