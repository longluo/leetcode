package com.longluo.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class Offer39_majorityElement {

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
