package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Problem912_sortArray {

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortArray_bubble(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    isSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (isSorted) {
                break;
            }
        }

        return nums;
    }

    public static int[] sortArray_merge(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        mergeSort(nums, 0, len - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[nums.length];
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] >= nums[j]) {
                temp[t++] = nums[j++];
            } else {
                temp[t++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }

        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    public static int[] sortArray_quick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
            }
            while (low < high && nums[low] < pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
            }
        }
        nums[low] = pivot;
        return low;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(sortArray_bubble(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(sortArray_merge(new int[]{5, 2, 3, 1})));
    }
}
