package com.longluo.studyplan.programming_skills;

/**
 * 1588. 所有奇数长度子数组的和
 * <p>
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class Problem1588_SumOfAllOddLengthSubarrays {

    // BF time: O(n^2) space: O(1)
    public static int sumOddLengthSubarrays_bf(int[] arr) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += arr[j];
                if (((j - i + 1) & 1) == 1) {
                    ans += sum;
                }
            }
        }

        return ans;
    }

    // PrefixSum time: O(n^2) space: O(1)
    public static int sumOddLengthSubarrays_prefix(int[] arr) {
        int ans = 0;
        int len = arr.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) % 2 == 1) {
                    ans += prefixSum[i] - prefixSum[j];
                }
            }
        }

        return ans;
    }

    // Math time: O(n) space: O(1)
    public static int sumOddLengthSubarrays_math(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int leftCount = i;
            int rightCount = len - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;

            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("58 ?= " + sumOddLengthSubarrays_bf(new int[]{1, 4, 2, 5, 3}));
        System.out.println("58 ?= " + sumOddLengthSubarrays_prefix(new int[]{1, 4, 2, 5, 3}));
    }
}
