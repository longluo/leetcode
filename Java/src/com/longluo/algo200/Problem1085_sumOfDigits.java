package com.longluo.algo200;

/**
 * 1085. 最小元素各数位之和
 * <p>
 * 给你一个正整数的数组 A。
 * <p>
 * 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
 * <p>
 * 最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。
 * <p>
 * 示例 1:
 * 输入：[34,23,1,24,75,33,54,8]
 * 输出：0
 * 解释：
 * 最小元素为 1 ，该元素各个数位上的数字之和 S = 1 ，是奇数所以答案为 0 。
 * <p>
 * 示例 2：
 * 输入：[99,77,33,66,55]
 * 输出：1
 * 解释：
 * 最小元素为 33 ，该元素各个数位上的数字之和 S = 3 + 3 = 6 ，是偶数所以答案为 1 。
 * <p>
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 100
 * <p>
 * https://leetcode.cn/problems/sum-of-digits-in-the-minimum-number/
 */
public class Problem1085_sumOfDigits {

    // Math time: O(n) space: O(1)
    public static int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
        }

        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }

        return sum % 2 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + sumOfDigits(new int[]{100}));
        System.out.println("0 ?= " + sumOfDigits(new int[]{34, 23, 1, 24, 75, 33, 54, 8}));
        System.out.println("1 ?= " + sumOfDigits(new int[]{99, 77, 33, 66, 55}));
    }
}
