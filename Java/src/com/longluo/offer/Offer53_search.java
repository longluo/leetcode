package com.longluo.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class Offer53_search {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("0 ?= " + search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println("2 ?= " + search(new int[]{2, 2}, 2));
        System.out.println("3 ?= " + search(new int[]{3, 3, 3}, 3));
    }
}
