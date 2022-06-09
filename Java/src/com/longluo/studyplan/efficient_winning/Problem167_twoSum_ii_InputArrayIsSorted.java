package com.longluo.studyplan.efficient_winning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 提示：
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Problem167_twoSum_ii_InputArrayIsSorted {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static int[] twoSum_bf(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[0];
    }

    // Two Pointers time: O(n) space: O(1)
    public static int[] twoSum_tp(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && numbers[left] + numbers[right] > target) {
                right--;
            }

            while (left < right && numbers[left] + numbers[right] < target) {
                left++;
            }

            if (numbers[left] + numbers[right] == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
        }

        return ans;
    }

    public static int[] twoSum_tp_opt(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{-1, -1};
    }

    // Binary Search time: O(logn) space: O(1)
    public static int[] twoSum_bs(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int ret = binarySearch(numbers, i + 1, len - 1, target - numbers[i]);
            if (ret > 0) {
                ans[0] = i + 1;
                ans[1] = ret + 1;
                return ans;
            }
        }

        return ans;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return nums[left] == target ? left : -1;
    }

    // Binary Search time: O(logn) space: O(1)
    public static int[] twoSum_bs_opt(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return new int[0];
    }

    // Hash time: O(n) space: O(n)
    public static int[] twoSum_hash(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }

            map.putIfAbsent(numbers[i], i + 1);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_bf(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_tp(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_tp_opt(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_bs(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_bs_opt(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_hash(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_hash(new int[]{2, 3, 4}, 6)));
    }
}
