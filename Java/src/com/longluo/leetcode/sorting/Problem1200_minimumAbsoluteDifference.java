package com.longluo.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * <p>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * <p>
 * https://leetcode.cn/problems/minimum-absolute-difference/
 */
public class Problem1200_minimumAbsoluteDifference {

    // Sorting time: O(n^2) space: O(n)
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int minAbsDiff = arr[1] - arr[0];
        for (int i = 1; i < len; i++) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i - 1]);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = arr[j] - arr[i];
                if (diff > minAbsDiff) {
                    break;
                }

                if (diff == minAbsDiff) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(arr[j]);
                    ans.add(pair);
                }
            }
        }

        return ans;
    }

    // Sorting time: O(nlogn) space: O(logn)
    public static List<List<Integer>> minimumAbsDifference_opt(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int min = arr[1] - arr[0];
        for (int i = 0; i < len - 1; i++) {
            int cur = arr[i + 1] - arr[i];
            if (cur > min) {
                continue;
            }

            if (cur < min) {
                ans.clear();
                min = cur;
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(arr[i]);
            pair.add(arr[i + 1]);
            ans.add(pair);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[1,2],[2,3],[3,4]] ?= " + minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println("[[1,2],[2,3],[3,4]] ?= " + minimumAbsDifference_opt(new int[]{4, 2, 1, 3}));
    }
}
