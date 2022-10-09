package com.longluo.studyplan.binary_search.i;

import java.util.*;

/**
 * 1838. 最高频元素的频数
 * <p>
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 */
public class Problem1838_frequencyOfTheMostFrequentElement {

    // BF time: O(n^2) space: O(1)
    // Failed for not the best solution.
    public static int maxFrequency_bf_wrong(int[] nums, int k) {
        int len = nums.length;
        int ans = 1;
        for (int i = 0; i < len; i++) {
            int remain = k;
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] > nums[i]) {
                    continue;
                }

                remain -= nums[i] - nums[j];
                if (remain >= 0) {
                    cnt++;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static int maxFrequency_bf(int[] nums, int k) {
        int len = nums.length;
        int ans = 1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxFrequency_bf(new int[]{1, 2, 4}, 5));
        System.out.println("2 ?= " + maxFrequency_bf(new int[]{1, 4, 8, 13}, 5));
        System.out.println("22 ?= " + maxFrequency_bf(new int[]{9940, 9995, 9944, 9937, 9941, 9952, 9907, 9952, 9987, 9964, 9940, 9914, 9941, 9933, 9912, 9934, 9980, 9907, 9980, 9944, 9910, 9997}, 7925));
        System.out.println("73 ?= " + maxFrequency_bf(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056));
    }
}
