package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 * <p>
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：[3]
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * <p>
 * https://leetcode-cn.com/problems/majority-element-ii/
 */
public class Problem229_majorityElement {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int len = nums.length;
        int target = len / 3;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > target) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3] ?= " + majorityElement(new int[]{3, 2, 3}));
        System.out.println("[1] ?= " + majorityElement(new int[]{1}));
        System.out.println("[1, 2] ?= " + majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
