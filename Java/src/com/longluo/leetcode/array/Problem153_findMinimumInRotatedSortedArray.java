package com.longluo.leetcode.array;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为n的数组，预先按照升序排列，经由1到n次 旋转后，得到输入数组。例如，
 * 原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转4次，则可以得到[4,5,6,7,0,1,2]
 * 若旋转4次，则可以得到[0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]。
 * 给你一个元素值 互不相同 的数组nums，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的最小元素 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转3次得到输入数组。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转4次得到输入数组。
 * <p>
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转4次得到输入数组。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums中的所有整数互不相同
 * nums原来是一个升序排序的数组，并进行了1至n次旋转
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Problem153_findMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int minVal = 5001;
        for (int i = 0; i < len; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
        }

        return minVal;
    }

    public static int findMin_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }

        return nums[begin];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println("1 ?= " + findMin_2(new int[]{3, 4, 5, 1, 2}));
        System.out.println("0 ?= " + findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("0 ?= " + findMin_2(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("11 ?= " + findMin(new int[]{11, 13, 15, 17}));
        System.out.println("11 ?= " + findMin_2(new int[]{11, 13, 15, 17}));
    }
}
