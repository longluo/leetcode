package com.longluo.offer_ii;

import java.util.Arrays;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * <p>
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，
 * 所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * 示例 1：
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * 注意：本题与主站 167 题相似（下标起点不同）：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * https://leetcode-cn.com/problems/kLl5u1/
 */
public class Offer2_06_twoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    public static int[] twoSum_1(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (numbers[left] + numbers[right] > target) {
                right--;
            }
            while (numbers[left] + numbers[right] < target) {
                left++;
            }
            if (numbers[left] + numbers[right] == target) {
                res[0] = left;
                res[1] = right;
                return res;
            }
        }

        return res;
    }

    public static int[] twoSum_2(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        int idx = 0;
        while (idx < n && numbers[idx] <= target / 2) {
            int low = idx + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == target - numbers[idx]) {
                    res[0] = idx;
                    res[1] = mid;
                    return res;
                } else if (numbers[mid] > target - numbers[idx]) {
                    high = mid - 1;
                } else if (numbers[mid] < target - numbers[idx]) {
                    low = mid + 1;
                }
            }

            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[1, 3] ?= " + Arrays.toString(twoSum(new int[]{1, 2, 4, 6, 10}, 8)));
        System.out.println("[1, 3] ?= " + Arrays.toString(twoSum_1(new int[]{1, 2, 4, 6, 10}, 8)));
        System.out.println("[1, 3] ?= " + Arrays.toString(twoSum_2(new int[]{1, 2, 4, 6, 10}, 8)));

        System.out.println("[0, 2] ?= " + Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println("[0, 2] ?= " + Arrays.toString(twoSum_2(new int[]{2, 3, 4}, 6)));
        System.out.println("[0, 1] ?= " + Arrays.toString(twoSum_2(new int[]{0, 0, 3, 4}, 0)));
        System.out.println("[3, 4] ?= " + Arrays.toString(twoSum_2(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8)));
    }
}
