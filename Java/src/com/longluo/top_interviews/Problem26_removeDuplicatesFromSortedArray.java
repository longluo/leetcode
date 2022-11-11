package com.longluo.top_interviews;

/**
 * 26. 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * <p>
 * // nums是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度2，并且原数组nums的前两个元素被修改为1, 2。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度5， 并且原数组nums的前五个元素被修改为0, 1, 2, 3, 4。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * 0 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按升序排列
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Problem26_removeDuplicatesFromSortedArray {

    // BF time: O(n) space: O(n)
    public static int removeDuplicates_bf(int[] nums) {
        int len = nums.length;

        int[] expected = new int[len];
        expected[0] = nums[0];
        int idx = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] > expected[idx]) {
                idx++;
                expected[idx] = nums[i];
            }
        }

        for (int i = 0; i <= idx; i++) {
            nums[i] = expected[i];
        }

        return idx + 1;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums.length;
        }

        int slow = 0;
        int fast = 1;
        while (slow <= fast && fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }

            if (fast < nums.length && nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + removeDuplicates_bf(new int[]{1, 1, 2}));
        System.out.println("5 ?= " + removeDuplicates_bf(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

        System.out.println("2 ?= " + removeDuplicates(new int[]{1, 1, 2}));
        System.out.println("5 ?= " + removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
