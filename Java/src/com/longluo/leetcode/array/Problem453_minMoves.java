package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * <p>
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 答案保证符合 32-bit 整数
 * <p>
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 */
public class Problem453_minMoves {

    public static int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int ans = 0;
        for (int x : nums) {
            ans += x - minNum;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minMoves(new int[]{1, 2, 3}));
        System.out.println("0 ?= " + minMoves(new int[]{1, 1, 1}));
        System.out.println("1 ?= " + minMoves(new int[]{1, 2}));
        System.out.println("999999999 ?= " + minMoves(new int[]{1, 1, 1000000000}));
        System.out.println("300 ?= " + minMoves(new int[]{-100, 0, 100}));
    }
}
