package com.longluo.offer_ii;

/**
 * 剑指 Offer II 068. 查找插入位置
 * <p>
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为无重复元素的升序排列数组
 * -10^4 <= target <= 10^4
 * <p>
 * 注意：本题与主站 35 题相同： https://leetcode.cn/problems/search-insert-position/
 * <p>
 * https://leetcode.cn/problems/N6YdxV/
 */
public class Offer2_68_searchInsert {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                ans = i;
            } else if (i < n - 1 && nums[i] < target && nums[i + 1] > target) {
                ans = i + 1;
            } else if (i == n - 1 && nums[i] < target) {
                ans = i + 1;
            } else if (i == 0 && nums[i] > target) {
                ans = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
