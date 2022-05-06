package com.longluo.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * <p>
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
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears only once.
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 * <p>
 * https://leetcode.com/problems/single-number/
 */
public class Problem136_singleNumber {

    // XOR time: O(n) space: O(1)
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    // HashMap time: O(n) space: O(n)
    public static int singleNumber_map(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            if (freq.get(num) == 1) {
                return num;
            }
        }

        return 0;
    }

    // Sort time: O(nlogn) space: O(logn)
    public static int singleNumber_sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                ans = nums[i];
                break;
            } else if (i == n - 1 && nums[i] != nums[i - 1]) {
                ans = nums[i];
                break;
            } else if (i > 0 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + singleNumber(new int[]{2, 2, 1}));
        System.out.println("4 ?= " + singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println("4 ?= " + singleNumber_sort(new int[]{4, 1, 2, 1, 2}));
        System.out.println("4 ?= " + singleNumber_map(new int[]{4, 1, 2, 1, 2}));
    }
}
