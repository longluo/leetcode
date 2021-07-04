package com.longluo.leetcode.bitmanipulation;

import java.util.Arrays;
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
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class Problem645_setMismatch {

    public static int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        int n = nums.length;
        int[] ans = new int[2];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                ans[0] = nums[i];
            } else {
                set.add(nums[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                ans[1] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2,3] ?= " + Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println("[1,2] ?= " + Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println("[3,2] ?= " + Arrays.toString(findErrorNums(new int[]{1, 3, 3})));
    }
}
