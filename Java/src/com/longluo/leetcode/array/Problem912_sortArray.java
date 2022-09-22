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

    public static int[] bubbleSort(int[] nums) {
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

    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums;
    }

    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

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

    public static int[] shellSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

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

    public static int[] heapSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        //1.构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(nums, 0, j);//重新对堆进行调整
        }

        return nums;
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static int[] mergeSort(int[] nums) {
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

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(bubbleSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(selectSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(insertSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(shellSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(heapSort(new int[]{5, 2, 3, 1})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(mergeSort(new int[]{5, 2, 3, 1})));

        System.out.println("[1, 2, 3, 4, 5] ?= " + Arrays.toString(quickSort(new int[]{1, 2, 3, 4, 5})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(quickSort(new int[]{5, 1, 1, 2, 0, 0})));
        System.out.println("[1, 2, 3, 5] ?= " + Arrays.toString(quickSort(new int[]{5, 2, 3, 1})));
    }
}
