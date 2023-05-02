package com.longluo.leetcode.array;

/**
 * 1822. 数组元素积的符号
 * <p>
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * 示例 3：
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 */
public class Problem1822_signOfTheProductOfAnArray {

    // Math time: O(n) space: O(1)
    public static int arraySign(int[] nums) {
        int negCnt = 0;

        for (int x : nums) {
            if (x == 0) {
                return 0;
            } else if (x < 0) {
                negCnt++;
            }
        }

        return negCnt % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println("0 ?= " + arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println("-1 ?= " + arraySign(new int[]{-1, 1, -1, 1, -1}));
    }
}
