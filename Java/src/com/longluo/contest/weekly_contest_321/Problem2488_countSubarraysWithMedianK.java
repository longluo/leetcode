package com.longluo.contest.weekly_contest_321;

/**
 * https://leetcode.cn/contest/weekly-contest-321
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 2488. 统计中位数为 K 的子数组
 * <p>
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * <p>
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * <p>
 * 注意：
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 * <p>
 * https://leetcode.cn/problems/count-subarrays-with-median-k/
 */
public class Problem2488_countSubarraysWithMedianK {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            int equal = 0;

            int cnt = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] < k) {
                    left++;
                } else if (nums[j] > k) {
                    right++;
                } else {
                    equal++;
                }

                cnt++;
                if (cnt % 2 == 1) {
                    if (left == right && equal == 1) {
                        ans++;
                    }
                } else {
                    if (left + 1 == right && equal == 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // PrefixSums time: O(n^2) space: O(n)
    // TLE
    public static int countSubarrays_prefix(int[] nums, int k) {
        int len = nums.length;

        int[] prefixSums = new int[len + 1];

        for (int i = 0; i < len; i++) {
            if (nums[i] > k) {
                prefixSums[i + 1] = prefixSums[i] + 1;
            } else if (nums[i] < k) {
                prefixSums[i + 1] = prefixSums[i] - 1;
            } else {
                prefixSums[i + 1] = prefixSums[i];
            }
        }

        int ans = 0;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                int sum = prefixSums[j + i] - prefixSums[j];
                if (i % 2 == 0) {
                    ans += sum == 1 ? 1 : 0;
                } else {
                    ans += sum == 0 ? 1 : 0;
                }
            }
        }

        return ans;
    }

    // HashMap time: O(n) space: O(n)
    public static int countSubarrays_hashmap(int[] nums, int k) {
        int len = nums.length;

        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int i = idx - 1, sum = 0; i >= 0; i--) {
            sum += nums[i] < k ? 1 : -1;
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        int ans = countMap.get(0) + countMap.getOrDefault(-1, 0);
        for (int i = idx + 1, sum = 0; i < len; i++) {
            sum += nums[i] > k ? 1 : -1;
            ans += countMap.getOrDefault(sum, 0) + countMap.getOrDefault(sum - 1, 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countSubarrays(new int[]{2, 3, 1}, 3));
        System.out.println("3 ?= " + countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println("3 ?= " + countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1));
        System.out.println("13 ?= " + countSubarrays(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6));

        System.out.println("1 ?= " + countSubarrays_prefix(new int[]{2, 3, 1}, 3));
        System.out.println("3 ?= " + countSubarrays_prefix(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println("3 ?= " + countSubarrays_prefix(new int[]{2, 5, 1, 4, 3, 6}, 1));
        System.out.println("13 ?= " + countSubarrays_prefix(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6));

        System.out.println("3 ?= " + countSubarrays_hashmap(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println("13 ?= " + countSubarrays_hashmap(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6));
    }
}


