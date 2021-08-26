package com.longluo.studyplan.algorithms;

/**
 * https://leetcode-cn.com/problems/binary-search/
 */
public class Day01_BinarySearch_704 {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println("-1 ?= " + search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println("0 ?= " + search(new int[]{5}, 5));
    }
}
