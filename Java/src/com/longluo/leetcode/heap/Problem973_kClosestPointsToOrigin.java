package com.longluo.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 973. 最接近原点的 K 个点
 * <p>
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * <p>
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 * <p>
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * 提示：
 * 1 <= k <= points.length <= 10^4
 * -10^4 < xi, yi < 10^4
 * <p>
 * https://leetcode.cn/problems/k-closest-points-to-origin/
 */
public class Problem973_kClosestPointsToOrigin {

    // Sort time: O(nlogn) space: O(logn)
    public static int[][] kClosest_sort(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> {
            int x1 = p1[0], y1 = p1[1];
            int x2 = p2[0], y2 = p2[1];

            return x1 * x1 + y1 * y1 - (x2 * x2 + y2 * y2);
        });

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[-2, 2]] ?= " + Arrays.deepToString(kClosest_sort(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
