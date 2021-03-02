package com.longluo.leetcode.dp;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，
 * 包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * 示例：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 0 <= i <= j < nums.length
 * 最多调用 10^4 次 sumRange 方法
 */
public class Problem303_NumArray {

    static class NumArray {
        int[] array;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            array = new int[nums.length];
            System.arraycopy(nums, 0, array, 0, nums.length);
        }

        public int sumRange(int i, int j) {
            int total = 0;
            for (int idx = i; idx <= j; idx++) {
                total += array[idx];
            }

            return total;
        }
    }

    static class NumArray_2 {
        int[] dp;

        public NumArray_2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            dp = new int[nums.length + 1];
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    public static void main(String[] args) {
        int[] testArr = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(testArr);

        System.out.println("1 ?= " + numArray.sumRange(0, 2));
        System.out.println("-1 ?= " + numArray.sumRange(2, 5));
        System.out.println("-3 ?= " + numArray.sumRange(0, 5));

        NumArray_2 numArray_2 = new NumArray_2(testArr);
        System.out.println("1 ?= " + numArray_2.sumRange(0, 2));
        System.out.println("-1 ?= " + numArray_2.sumRange(2, 5));
        System.out.println("-3 ?= " + numArray_2.sumRange(0, 5));
    }
}
