package com.longluo.leetcode.MonoStack;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 * <p>
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * <p>
 * 示例 2：
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * <p>
 * 示例 3：
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * <p>
 * 示例 4：
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 */
public class Problem1574_shortestSubarrayToBeRemovedToMakeArraySorted {

    // TODO: 2023/3/25
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        for (int l = 0; true; l++) {
            boolean flag = true;

            int last = -1;

            for (int i = 0; i < n - l; i++) {
                if (i == 0) {
                    last = arr[i + l];
                }

                for (int j = 0; j < i; j++) {
                    if (arr[j] <= last) {
                        flag = false;
                        break;
                    }
                }

                for (int j = i + l; j < n; j++) {

                }
            }

            if (flag) {
                return l;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + findLengthOfShortestSubarray(new int[]{1}));
        System.out.println("0 ?= " + findLengthOfShortestSubarray(new int[]{1, 2, 3}));
        System.out.println("4 ?= " + findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println("3 ?= " + findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }
}
