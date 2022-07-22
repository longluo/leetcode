package com.longluo.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 757. 设置交集大小至少为2
 * <p>
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * 输出这个最小集合S的大小。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * 输出: 3
 * 解释:
 * 考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
 * 且这是S最小的情况，故我们输出3。
 * <p>
 * 示例 2:
 * 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * 输出: 5
 * 解释:
 * 最小的集合S = {1, 2, 3, 4, 5}.
 * <p>
 * 注意:
 * intervals 的长度范围为[1, 3000]。
 * intervals[i] 长度为 2，分别代表左、右边界。
 * intervals[i][j] 的值是 [0, 10^8]范围内的整数。
 * <p>
 * https://leetcode.cn/problems/set-intersection-size-at-least-two/
 */
public class Problem757_setIntersectionSizeAtLeastTwo {

    // Greedy + Sort time: O(nlogn) space: O(logn)
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        });

        List<Integer> res = new ArrayList<>();
        res.add(intervals[0][1] - 1);
        res.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            int size = res.size();
            int count = 0;
            for (int j = size - 1; j >= 0; j--) {
                if (res.get(j) >= left && res.get(j) <= right) {
                    count++;
                }
            }

            if (count == 0) {
                res.add(left);
                res.add(left + 1);
            } else if (count == 1) {
                res.add(left + 1);
            }
        }

        return res.size();
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + intersectionSizeTwo(new int[][]{{3, 13}, {2, 8}, {5, 10}}));
        System.out.println("3 ?= " + intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println("5 ?= " + intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));
        System.out.println("5 ?= " + intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}));
    }
}
