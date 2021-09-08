package com.longluo.leetcode.slidingwindow;

/**
 * 1004. 最大连续1的个数 III
 * <p>
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 提示：
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 * <p>
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class Problem1004_maxConsecutiveOnes_iii {

    public static int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            int remain = K;
            int j = i;
            while (remain >= 0 && j < A.length) {
                if (A[j] == 1) {
                    count++;
                    j++;
                } else if (A[j] == 0) {
                    if (remain > 0) {
                        remain--;
                        count++;
                        j++;
                    } else {
                        break;
                    }
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static int longestOnes2(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (left < A.length && right < A.length && left <= right) {

            while (right < A.length && A[right] == 1) {
                right++;
                count++;
            }

            while (right < A.length && A[right] == 0 && K > 0) {
                right++;
                count++;
                K--;
            }

            ans = Math.max(ans, count);

            while (right < A.length && K == 0 && A[right] == 0 && A[left] == 1) {
                left++;
                count--;
            }

            while (right < A.length && K == 0 && A[right] == 0 && A[left] == 0) {
                left++;
                right++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("10 ?= " + longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

        System.out.println("6 ?= " + longestOnes2(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("10 ?= " + longestOnes2(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
