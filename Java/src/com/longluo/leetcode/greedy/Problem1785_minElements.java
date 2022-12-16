package com.longluo.leetcode.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1785. 构成特定和需要添加的最少元素
 * <p>
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * <p>
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * <p>
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= limit <= 10^6
 * -limit <= nums[i] <= limit
 * -10^9 <= goal <= 10^9
 * <p>
 * https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 */
public class Problem1785_minElements {

    // Greedy time: O(n) space: O(1)
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }

        long diff = Math.abs(sum - goal);

        return (int) ((diff + limit - 1) / limit);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println("1 ?= " + minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }
}
