package com.longluo.leetcode.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * <p>
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * 示例 1：
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * <p>
 * 示例 2：
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * <p>
 * 示例 3：
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * <p>
 * 提示：
 * 0 <= arr.length <= 10^5
 * -10^9 <= arr[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 */
public class Problem1331_rankTransformOfAnArray {

    // Sorted + HashMap time: O(nlogn) space: O(n)
    public static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> ranksMap = new HashMap<>();
        for (int x : sorted) {
            if (!ranksMap.containsKey(x)) {
                ranksMap.put(x, ranksMap.size() + 1);
            }
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = ranksMap.get(arr[i]);
        }

        return ans;
    }

    // BF time: O(nlogn + n^2) space: O(n)
    // TLE
    public static int[] arrayRankTransform_ugly(int[] arr) {
        if (arr == null || arr.length < 1) {
            return new int[]{};
        }

        int len = arr.length;
        int[][] sorted = new int[len][2];
        for (int i = 0; i < len; i++) {
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (o1, o2) -> o1[0] - o2[0]);

        sorted[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (sorted[i][0] > sorted[i - 1][0]) {
                sorted[i][1] = sorted[i - 1][1] + 1;
            } else {
                sorted[i][1] = sorted[i - 1][1];
            }
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (sorted[j][0] == arr[i]) {
                    ans[i] = sorted[j][1];
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[4, 1, 2, 3] ?= " + Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println("[4, 1, 2, 3] ?= " + Arrays.toString(arrayRankTransform_ugly(new int[]{40, 10, 20, 30})));
    }
}
