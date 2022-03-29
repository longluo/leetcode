package com.longluo.leetcode.array;

import java.util.*;

/**
 * 217. 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回true 。如果数组中每个元素都不相同，则返回false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * https://leetcode.com/problems/contains-duplicate/
 */
public class Problem217_containsDuplicate {

    /**
     * HashMap
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                return true;
            } else {
                numMap.put(num, 1);
            }
        }

        return false;
    }

    /**
     * Set
     */
    public static boolean containsDuplicate_set(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Sort
     */
    public static boolean containsDuplicate_sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("false ?= " + containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println("true ?= " + containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));

        System.out.println("true ?= " + containsDuplicate_set(new int[]{1, 2, 3, 1}));
        System.out.println("false ?= " + containsDuplicate_set(new int[]{1, 2, 3, 4}));

        System.out.println("true ?= " + containsDuplicate_sort(new int[]{1, 2, 3, 1}));
        System.out.println("false ?= " + containsDuplicate_sort(new int[]{1, 2, 3, 4}));
    }
}
