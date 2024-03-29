package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 1470. 重新排列数组
 * <p>
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 示例 1：
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * <p>
 * 提示：
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * https://leetcode.cn/problems/shuffle-the-array/
 */
public class Problem1470_shuffleTheArray {

    // Simulate time: O(n) space: O(n)
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];

        int j = 0;
        for (int i = 0; i < 2 * n; ) {
            res[i++] = nums[j];
            res[i++] = nums[j + n];
            j++;
        }

        return res;
    }

    // Opt time: O(n) space: O(n)
    public static int[] shuffle_opt(int[] nums, int n) {
        int[] res = new int[n * 2];

        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }

        return res;
    }

    // Simulate time: O(n) space: O(1)
    public static int[] shuffle_o1(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            if (nums[i] > 0) {
                int j = i;
                while (nums[i] > 0) {
                    j = j < n ? 2 * j : 2 * (j - n) + 1;

                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    nums[j] = -nums[j];
                }
            }
        }

        for (int i = 0; i < 2 * n; i++) {
            nums[i] = -nums[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("[2,3,5,4,1,7] ?= " + Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println("[2,3,5,4,1,7] ?= " + Arrays.toString(shuffle_opt(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println("[2,3,5,4,1,7] ?= " + Arrays.toString(shuffle_o1(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}
