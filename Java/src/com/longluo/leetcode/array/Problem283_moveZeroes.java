package com.longluo.leetcode.array;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Problem283_moveZeroes {

    // Use BF New Array O(n) O(n)
    public static void moveZeroes_bf(int[] nums) {
        int len = nums.length;
        int[] newArr = new int[len];
        for (int i = 0, j = 0; i < len && j < len; i++) {
            if (nums[i] != 0) {
                newArr[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < len; i++) {
            nums[i] = newArr[i];
        }
    }

    // Use Two Pointers O(n) O(1)
    public static void moveZeroes_tp(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }

            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args) {
        moveZeroes_bf(new int[]{0, 1, 0, 3, 12});
        moveZeroes_tp(new int[]{0, 1, 0, 3, 12});
    }
}
