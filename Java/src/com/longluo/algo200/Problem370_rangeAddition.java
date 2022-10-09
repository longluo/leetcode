package com.longluo.algo200;

import java.util.Arrays;

/**
 * 370. 区间加法
 * <p>
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * <p>
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
 * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * <p>
 * 请你返回 k 次操作后的数组。
 * <p>
 * 示例:
 * 输入: length = 5, updates = [[1,3,2},{2,4,3},{0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * <p>
 * 初始状态:
 * [0,0,0,0,0]
 * <p>
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * <p>
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * <p>
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 * <p>
 * https://leetcode.cn/problems/range-addition/
 */
public class Problem370_rangeAddition {

    // Simulate time: O(n) space: O(n)
    public static int[] getModifiedArray_bf(int length, int[][] updates) {
        int[] ans = new int[length];

        for (int[] op : updates) {
            int left = op[0];
            int right = op[1];
            int inc = op[2];

            for (int i = left; i <= right; i++) {
                ans[i] += inc;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-2, 0, 3, 5, 3] ?= " + Arrays.toString(getModifiedArray_bf(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}})));
    }
}
