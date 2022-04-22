package com.longluo.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * <p>
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class Problem560_subarraySumEqualsK {

    // BF time: O(n^2) space: O(n)
    public static int subarraySum_bf(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // PrefixSum time: O(n^2) space: O(2*n)
    public static int subarraySum_prefixSum(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[] prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (prefixSums[j] - prefixSums[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // PrefixSum + Hash time: O(n) space: O(2*n)
    public static int subarraySum_prefixSum_hash(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[] prefixSums = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            if (map.containsKey(prefixSums[i + 1] - k)) {
                ans += map.get(prefixSums[i + 1] - k);
            }
            map.put(prefixSums[i + 1], map.getOrDefault(prefixSums[i + 1], 0) + 1);
        }

        return ans;
    }

    // PrefixSum + Hash time: O(n) space: O(n)
    public static int subarraySum_prefixSum_hash_opt(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        subarraySum_prefixSum(new int[]{1, 1, 1}, 2);
        subarraySum_prefixSum_hash(new int[]{1, 1, 1}, 2);
        subarraySum_prefixSum_hash(new int[]{1}, 0);
    }
}
