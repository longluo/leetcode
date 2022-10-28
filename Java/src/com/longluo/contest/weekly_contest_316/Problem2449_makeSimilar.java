package com.longluo.contest.weekly_contest_316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2449. 使数组相似的最少操作次数
 * <p>
 * 给你两个正整数数组 nums 和 target ，两个数组长度相等。
 * <p>
 * 在一次操作中，你可以选择两个 不同 的下标 i 和 j ，其中 0 <= i, j < nums.length ，并且：
 * 令 nums[i] = nums[i] + 2 且
 * 令 nums[j] = nums[j] - 2 。
 * 如果两个数组中每个元素出现的频率相等，我们称两个数组是 相似 的。
 * <p>
 * 请你返回将 nums 变得与 target 相似的最少操作次数。测试数据保证 nums 一定能变得与 target 相似。
 * <p>
 * 示例 1：
 * 输入：nums = [8,12,6], target = [2,14,10]
 * 输出：2
 * 解释：可以用两步操作将 nums 变得与 target 相似：
 * - 选择 i = 0 和 j = 2 ，nums = [10,12,4] 。
 * - 选择 i = 1 和 j = 2 ，nums = [10,14,2] 。
 * 2 次操作是最少需要的操作次数。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,5], target = [4,1,3]
 * 输出：1
 * 解释：一步操作可以使 nums 变得与 target 相似：
 * - 选择 i = 1 和 j = 2 ，nums = [1,4,3] 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,1,1], target = [1,1,1,1,1]
 * 输出：0
 * 解释：数组 nums 已经与 target 相似。
 * <p>
 * 提示：
 * n == nums.length == target.length
 * 1 <= n <= 10^5
 * 1 <= nums[i], target[i] <= 10^6
 * nums 一定可以变得与 target 相似。
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-arrays-similar/
 */
public class Problem2449_makeSimilar {

    // Greedy
    // TODO: 2022/10/28
    public static long makeSimilar_bf(int[] nums, int[] target) {
        List<Integer> srcEven = new ArrayList<>();
        List<Integer> srcOdd = new ArrayList<>();

        List<Integer> targetEven = new ArrayList<>();
        List<Integer> targetOdd = new ArrayList<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                srcEven.add(x);
            } else {
                srcOdd.add(x);
            }
        }

        for (int x : target) {
            if (x % 2 == 0) {
                targetEven.add(x);
            } else {
                targetOdd.add(x);
            }
        }

        Collections.sort(srcEven);
        Collections.sort(srcOdd);

        Collections.sort(targetEven);
        Collections.sort(targetOdd);

        long ans = 0L;
        for (int i = 0; i < srcEven.size(); i++) {
            ans += Math.abs(srcEven.get(i) - targetEven.get(i));
        }

        for (int i = 0; i < srcOdd.size(); i++) {
            ans += Math.abs(srcOdd.get(i) - targetOdd.get(i));
        }

        return ans / 4;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + makeSimilar_bf(new int[]{8, 12, 6}, new int[]{2, 14, 10}));
        System.out.println("1 ?= " + makeSimilar_bf(new int[]{1, 2, 5}, new int[]{4, 1, 3}));
        System.out.println("0 ?= " + makeSimilar_bf(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }
}
