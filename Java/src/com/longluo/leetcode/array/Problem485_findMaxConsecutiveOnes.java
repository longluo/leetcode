package com.longluo.leetcode.array;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * <p>
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class Problem485_findMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            while (i < nums.length && nums[i] == 1) {
                cnt++;
                i++;
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
