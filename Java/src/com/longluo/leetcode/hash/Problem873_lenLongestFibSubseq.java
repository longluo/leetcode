package com.longluo.leetcode.hash;

/**
 * 873. 最长的斐波那契子序列的长度
 * <p>
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * 示例 1：
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * <p>
 * 示例 2：
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * <p>
 * 提示：
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 * <p>
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class Problem873_lenLongestFibSubseq {

    // BF time: O(n^3) space: O(1)
    public static int lenLongestFibSubseq_bf(int[] arr) {
        int len = arr.length;
        int max = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int first = arr[i];
                int second = arr[j];
                int cnt = 2;
                for (int k = j + 1; k < len; k++) {
                    if (first + second < arr[k]) {
                        break;
                    } else if (first + second > arr[k]) {
                        continue;
                    }

                    first = second;
                    second = arr[k];
                    cnt++;
                }

                max = Math.max(max, cnt >= 3 ? cnt : 0);
            }
        }

        return max;
    }

    // DP
    // TODO: 2022/8/24  
    public static int lenLongestFibSubseq_dp(int[] arr) {
        int len = arr.length;

        int max = 0;


        return max;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + lenLongestFibSubseq_bf(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println("3 ?= " + lenLongestFibSubseq_bf(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println("5 ?= " + lenLongestFibSubseq_bf(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));

        System.out.println("5 ?= " + lenLongestFibSubseq_dp(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));

    }
}
