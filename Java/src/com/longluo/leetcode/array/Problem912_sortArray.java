package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.Random;

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

    // Bubble time: O(n^2) space: O(1)
    // TLE
    public static int[] bubbleSort(int[] nums) {
        int len = nums.length;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    // Better
    public static int[] bubbleSort_opt(int[] nums) {
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

    // SelectSort time: O(n^2) space: O(1)
    // TLE
    public static int[] selectSort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            swap(nums, i, min);
        }

        return nums;
    }

    // InsertSort time: O(n^2) space: O(1)
    // TLE
    public static int[] insertSort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    // Insert Sort Opt
    public static int[] insertSort_opt(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int temp = nums[i];

            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = temp;
        }

        return nums;
    }

    //
    public static int[] shellSort(int[] nums) {
        int len = nums.length;

        for (int gap = len / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                while (j - gap >= 0 && nums[j] < nums[j - gap]) {
                    int temp = nums[j];
                    nums[j] = nums[j - gap];
                    nums[j - gap] = temp;
                    j -= gap;
                }
            }
        }

        return nums;
    }

    // HeapSort time: O(nlogn) space: O(1)
    public static int[] heapSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;

        // 1. build the Max Heap
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, len - 1);
        }

        // 2. swap Heap peek with the end, adjust the heap
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i - 1);
        }

        return nums;
    }

    private static void maxHeapify(int[] arr, int start, int end) {
        int parent = start;
        int child = 2 * start + 1;

        while (child <= end) {
            if (child + 1 <= end && arr[child] < arr[child + 1]) {
                child++;
            }

            if (arr[parent] < arr[child]) {
                swap(arr, parent, child);
                parent = child;
                child = 2 * child + 1;
            } else {
                break;
            }
        }
    }

    // MergeSort time: O(nlogn) space: O(n)
    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);

            if (nums[mid] <= nums[mid + 1]) {
                return;
            }

            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    // QuickSort time: O(nlogn) space: O(logn)
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int randomIdx = left + new Random().nextInt(right - left + 1);

        swap(nums, left, randomIdx);

        int pivot = nums[left];

        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt < right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            swap(nums, lt, gt);
            lt++;
            gt--;
        }

        swap(nums, left, gt);

        return gt;
    }

    // CountSort time: O(n) space: O(n)
    public static int[] countSort(int[] nums) {
        int OFFSET = 50000;
        int size = 10_0000;
        int[] count = new int[size + 1];

        for (int x : nums) {
            count[x + OFFSET]++;
        }

        int idx = 0;
        for (int i = 0; i <= size; i++) {
            if (count[i] <= 0) {
                continue;
            }

            for (int j = 0; j < count[i]; j++) {
                nums[idx] = i - OFFSET;
                idx++;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(bubbleSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(bubbleSort_opt(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(selectSort(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(insertSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(insertSort_opt(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(shellSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(heapSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(mergeSort(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 4, 5] ?= " + Arrays.toString(quickSort(new int[]{1, 2, 3, 4, 5})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(quickSort(new int[]{5, 1, 1, 2, 0, 0})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(quickSort(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(countSort(new int[]{5, 2, 3, 1})));
    }
}
