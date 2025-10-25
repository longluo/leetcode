package com.longluo.contest.weekly_contest_335;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-335
 */
public class Problem3 {

    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        boolean[] marked = new boolean[n];

        int ans = 0;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            while (marked[j]) {
                j--;
            }

            marked[j] = true;
            int left = binarySearchLeft(nums, j - 1, nums[j] / 2);
            while (left >= 0 && marked[left]) {
                left--;
            }
            if (left < 0) {
                break;
            }
            marked[left] = true;
            ans++;

            while (marked[i]) {
                i++;
            }

            int right = binarySearchRight(nums, i + 1, 2 * nums[i]);
            while (right >= 0 && right < n - 1 && marked[right]) {
                right++;
            }
            if (right < 0 || right > n - 1) {
                break;
            }
            marked[right] = true;
            ans++;
        }

        return ans * 2;
    }

    private static int binarySearchLeft(int[] array, int end, int target) {
        if (array[0] > target) {
            return -1;
        }

        int left = 0;
        int right = end;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return array[left] <= target ? left : -1;
    }

    private static int binarySearchRight(int[] array, int start, int target) {
        int n = array.length;
        if (array[n - 1] < target) {
            return -1;
        }

        int left = start;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return array[left] >= target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maxNumOfMarkedIndices(new int[]{7, 6, 8}));
        System.out.println("4 ?= " + maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        System.out.println("2 ?= " + maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        System.out.println("26 ?= " + maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
        System.out.println("64 ?= " + maxNumOfMarkedIndices(new int[]{1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78, 39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10}));
    }
}