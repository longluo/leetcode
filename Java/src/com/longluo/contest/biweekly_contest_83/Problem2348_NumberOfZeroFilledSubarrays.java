package com.longluo.contest.biweekly_contest_83;

/**
 * 2348. 全 0 子数组的数目
 * <p>
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,0,0,2,0,0,4]
 * 输出：6
 * 解释：
 * 子数组 [0] 出现了 4 次。
 * 子数组 [0,0] 出现了 2 次。
 * 不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,2,0,0]
 * 输出：9
 * 解释：
 * 子数组 [0] 出现了 5 次。
 * 子数组 [0,0] 出现了 3 次。
 * 子数组 [0,0,0] 出现了 1 次。
 * 不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
 * <p>
 * 示例 3：
 * 输入：nums = [2,10,2019]
 * 输出：0
 * 解释：没有全 0 子数组，所以我们返回 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/number-of-zero-filled-subarrays/
 */
public class Problem2348_NumberOfZeroFilledSubarrays {

    // Math time: O(n) space: O(1)
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }

        ans += cnt * (cnt + 1) / 2;

        return ans;
    }

    // Math time: O(n) space: O(1)
    public static long zeroFilledSubarray_opt(int[] nums) {
        long ans = 0;
        long subArrays = 0;

        for (int x : nums) {
            if (x == 0) {
                subArrays++;
                ans += subArrays;
            } else {
                subArrays = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        System.out.println("6 ?= " + zeroFilledSubarray_opt(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }
}
