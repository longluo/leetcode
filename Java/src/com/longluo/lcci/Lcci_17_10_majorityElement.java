package com.longluo.lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */
public class Lcci_17_10_majorityElement {

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
                if (freq.get(nums[i]) > len / 2) {
                    return nums[i];
                }
            } else {
                freq.put(nums[i], 1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println("-1 ?= " + majorityElement(new int[]{3, 2}));
        System.out.println("2 ?= " + majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println("1 ?= " + majorityElement(new int[]{1}));
    }
}
