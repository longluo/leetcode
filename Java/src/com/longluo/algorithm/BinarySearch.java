package com.longluo.algorithm;

/**
 * BinarySearch
 */
public class BinarySearch {

    /**
     * Returns the index of the specified target in the specified array.
     *
     * @param arr    the array of integers, must be sorted in ascending order
     * @param target the search target
     * @return index of key in array {@code arr} if present; {@code -1} otherwise
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Returns the index of the specified target in the specified array.
     *
     * @param arr    the array of integers, must be sorted in ascending order
     * @param low    the low index of the interval
     * @param high   the high index of the interval
     * @param target the search target
     * @return index of key in array {@code arr} if present; {@code -1} otherwise
     */
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            } else if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, high, target);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tst1 = {1, 2, 2, 4, 8, 9, 12, 15, 16, 16, 18, 22, 25, 36, 100};
        System.out.println("12 ?= " + binarySearch(tst1, 25));
        System.out.println("12 ?= " + binarySearch(tst1, 0, tst1.length - 1, 25));

        System.out.println("1 ?= " + binarySearch(tst1, 2));
        System.out.println("1 ?= " + binarySearch(tst1, 0, tst1.length - 1, 2));

        System.out.println("-1 ?= " + binarySearch(tst1, 101));
        System.out.println("-1 ?= " + binarySearch(tst1, 0, tst1.length - 1, 101));
    }
}
