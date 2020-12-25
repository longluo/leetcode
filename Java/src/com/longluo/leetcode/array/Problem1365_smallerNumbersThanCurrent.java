package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * <p>
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Problem1365_smallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && i != j) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[4,0,1,1,3] ?= " + Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println("[4,0,1,1,3] ?= " + Arrays.toString(smallerNumbersThanCurrent2(new int[]{8, 1, 2, 2, 3})));
        System.out.println("[2,1,0,3] ?= " + Arrays.toString(smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println("[2,1,0,3] ?= " + Arrays.toString(smallerNumbersThanCurrent2(new int[]{6, 5, 4, 8})));
        System.out.println("[0,0,0,0] ?= " + Arrays.toString(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
        System.out.println("[0,0,0,0] ?= " + Arrays.toString(smallerNumbersThanCurrent2(new int[]{7, 7, 7, 7})));
    }
}
