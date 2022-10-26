package com.longluo.leetcode.BitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 645. 错误的集合
 * <p>
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/set-mismatch/
 */
public class Problem645_setMismatch {

    // HashSet time: O(n) space: O(n)
    public static int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        int n = nums.length;
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                ans[0] = nums[i];
            }

            set.add(nums[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                ans[1] = i;
            }
        }

        return ans;
    }

    // BF time: O(n^2) space: O(1)
    public static int[] findErrorNums_bf(int[] nums) {
        int len = nums.length;

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                duplicate = i;
            } else if (count == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    // BF Opt time: O(n^2) space: O(1)
    public static int[] findErrorNums_bf_opt(int[] nums) {
        int len = nums.length;

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                duplicate = i;
            } else if (count == 0) {
                missing = i;
            }

            if (duplicate > 0 && missing > 0) {
                break;
            }
        }

        return new int[]{duplicate, missing};
    }

    // Sort time: O(nlogn) space: O(1)
    public static int[] findErrorNums_sort(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int[] ans = new int[2];

        int prev = 0;
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && nums[i] == nums[i + 1]) {
                ans[0] = nums[i];
            }

            if (nums[i] > prev + 1) {
                ans[1] = prev + 1;
            }

            prev = nums[i];
        }

        if (prev != len) {
            ans[1] = len;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] ?= " + Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println("[1, 2] ?= " + Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println("[3, 2] ?= " + Arrays.toString(findErrorNums(new int[]{1, 3, 3})));

        System.out.println("[3, 2] ?= " + Arrays.toString(findErrorNums_bf(new int[]{1, 3, 3})));

        System.out.println("[3, 2] ?= " + Arrays.toString(findErrorNums_bf_opt(new int[]{1, 3, 3})));

        System.out.println("[3, 2] ?= " + Arrays.toString(findErrorNums_sort(new int[]{1, 3, 3})));
        System.out.println("[2, 1] ?= " + Arrays.toString(findErrorNums_sort(new int[]{2, 2, 3})));
        System.out.println("[2, 3] ?= " + Arrays.toString(findErrorNums_sort(new int[]{1, 2, 2})));

        System.out.println("[3, 1] ?= " + Arrays.toString(findErrorNums_sort(new int[]{3, 2, 3, 4, 6, 5})));
        System.out.println("[2, 10] ?= " + Arrays.toString(findErrorNums_sort(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9})));
    }
}

