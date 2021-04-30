package com.longluo.leetcode.bit;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 */
public class Problem136_singleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + singleNumber(new int[]{2, 2, 1}));
        System.out.println("4 ?= " + singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
