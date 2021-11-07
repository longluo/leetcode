package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * <p>
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，
 * 该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * <p>
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Problem1218_longestSubsequence {

    public static int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        int ans = 1;
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int cnt = 1;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] == value + difference) {
                    cnt++;
                    value = arr[j];
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static int longestSubsequence_dp(int[] arr, int difference) {
        int len = arr.length;
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
            ans = Math.max(ans, dp.get(arr[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println("1 ?= " + longestSubsequence(new int[]{1, 2, 3, 4}, -1));
        System.out.println("2 ?= " + longestSubsequence(new int[]{1, 2, 3, 4}, 2));
        System.out.println("1 ?= " + longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println("4 ?= " + longestSubsequence(new int[]{1, 3, 5, 7}, 2));
        System.out.println("4 ?= " + longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        System.out.println("2 ?= " + longestSubsequence(new int[]{3, 0, -3, 4, -4, 7, 6}, 3));
        System.out.println("2 ?= " + longestSubsequence_dp(new int[]{3, 0, -3, 4, -4, 7, 6}, 3));
    }
}
