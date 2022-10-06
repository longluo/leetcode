package com.longluo.leetcode.math;

import java.util.Arrays;

/**
 * 927. 三等分
 * <p>
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * <p>
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。
 * 此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * <p>
 * 示例 1：
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * <p>
 * 示例 2：
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * <p>
 * 示例 3:
 * 输入：arr = [1,1,0,0,1]
 * 输出：[0,2]
 * <p>
 * 提示：
 * 3 <= arr.length <= 3 * 10^4
 * arr[i] 是 0 或 1
 * <p>
 * https://leetcode.cn/problems/three-equal-parts/
 */
public class Problem927_threeEqualParts {

    // BF time: O(n^4) space: O(1)
    // TLE
    public static int[] threeEqualParts_bf(int[] arr) {
        int len = arr.length;

        int[] ans = {-1, -1};

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int first = arr[0];
                    int second = arr[j];
                    int third = arr[k];

                    for (int m = 1; m < j; m++) {
                        first = first * 2 + arr[m];
                    }

                    for (int m = j + 1; m < k; m++) {
                        second = second * 2 + arr[m];
                    }

                    for (int m = k + 1; m < len; m++) {
                        third = third * 2 + arr[m];
                    }

                    if (first == second && second == third) {
                        ans[0] = j - 1;
                        ans[1] = k;
                        return ans;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-1, -1] ?= " + Arrays.toString(threeEqualParts_bf(new int[]{1, 1, 0, 1, 1})));
        System.out.println("[1, 4] ?= " + Arrays.toString(threeEqualParts_bf(new int[]{0, 1, 0, 1, 1})));
        System.out.println("[0, 3] ?= " + Arrays.toString(threeEqualParts_bf(new int[]{1, 0, 1, 0, 1})));
    }
}
