package com.longluo.top_interviews;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.com/problems/largest-number/
 */
public class Problem179_largestNumber {

    // Sort time: O(nlognlogm) space: O(n)
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }

        int len = nums.length;
        if (len <= 1) {
            return String.valueOf(nums[0]);
        }

        String[] numStrs = new String[len];
        for (int i = 0; i < len; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (o1, o2) -> {
            long num1 = Long.parseLong(o1 + o2);
            long num2 = Long.parseLong(o2 + o1);
            return (int) (num2 - num1);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(numStrs[i]);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("210 ?= " + largestNumber(new int[]{10, 2}));
        System.out.println("343234323 ?= " + largestNumber(new int[]{34323, 3432}));

        System.out.println("0 ?= " + largestNumber(new int[]{0}));
        System.out.println("0 ?= " + largestNumber(new int[]{0, 0}));
        System.out.println("0 ?= " + largestNumber(new int[]{0, 0, 0}));
        System.out.println("100 ?= " + largestNumber(new int[]{1, 0, 0}));
        System.out.println("1 ?= " + largestNumber(new int[]{1}));

        System.out.println("9534330 ?= " + largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println("10 ?= " + largestNumber(new int[]{10}));
        System.out.println("1113111311 ?= " + largestNumber(new int[]{111311, 1113}));
        System.out.println("9999999991 ?= " + largestNumber(new int[]{999999991, 9}));
    }
}
