package com.longluo.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -10^9<= nums[i]<= 10^9
 * nums是一个非递减数组
 * -10^9<= target<= 10^9
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53_search {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }

    public static int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                count++;
            } else if (nums[i] > target) {
                break;
            }
        }

        return count;
    }

    public static int search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int n = nums.length;
        int idx = binarySearch(nums, target);
        if (idx == -1) {
            return 0;
        }
        for (int i = idx; i < n; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }

        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int search_3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lowIdx = binarySearchLow(nums, target);
        int highIdx = binarySearchHigh(nums, target);

        return highIdx - lowIdx + 1;
    }

    public static int binarySearchLow(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int binarySearchHigh(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("2 ?= " + search_1(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("2 ?= " + search_2(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("2 ?= " + search_3(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("0 ?= " + search_2(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println("2 ?= " + search(new int[]{2, 2}, 2));
        System.out.println("3 ?= " + search(new int[]{3, 3, 3}, 3));
    }
}
