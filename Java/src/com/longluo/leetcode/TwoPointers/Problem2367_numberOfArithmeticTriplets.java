package com.longluo.leetcode.TwoPointers;

/**
 * 2367. 算术三元组的数目
 * <p>
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，
 * 则三元组 (i, j, k) 就是一个 算术三元组 ：
 * <p>
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 * <p>
 * https://leetcode.cn/problems/number-of-arithmetic-triplets/
 */
public class Problem2367_numberOfArithmeticTriplets {

    // BF time: O(n^3) space: O(1)
    public static int arithmeticTriplets_bf(int[] nums, int diff) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // Two Pointers time: O(n^2) space: O(1)
    public static int arithmeticTriplets_tp(int[] nums, int diff) {
        int ans = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = n - 1; j < k; ) {
                while (j < k && nums[j] - nums[i] < diff) {
                    j++;
                }

                while (j < k && nums[k] - nums[j] > diff) {
                    k--;
                }

                if (j < k && nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                    ans++;
                }

                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + arithmeticTriplets_bf(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println("2 ?= " + arithmeticTriplets_bf(new int[]{4, 5, 6, 7, 8, 9}, 2));

        System.out.println("2 ?= " + arithmeticTriplets_tp(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println("2 ?= " + arithmeticTriplets_tp(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }
}
