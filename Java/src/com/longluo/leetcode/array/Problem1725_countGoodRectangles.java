package com.longluo.leetcode.array;

/**
 * 1725. 可以形成最大正方形的矩形数目
 * <p>
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，
 * 矩形 [4,6] 可以切成边长最大为 4 的正方形。
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 * <p>
 * 示例 1：
 * 输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * 输出：3
 * 解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 * 最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 * <p>
 * 示例 2：
 * 输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= rectangles.length <= 1000
 * rectangles[i].length == 2
 * 1 <= li, wi <= 10^9
 * li != wi
 * <p>
 * https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
public class Problem1725_countGoodRectangles {

    public static int countGoodRectangles(int[][] rectangles) {
        int ans = 1;
        int len = rectangles.length;
        int maxLen = Math.min(rectangles[0][0], rectangles[0][1]);
        for (int i = 1; i < len; i++) {
            int[] rect = rectangles[i];
            int rectLen = Math.min(rect[0], rect[1]);
            if (maxLen < rectLen) {
                maxLen = rectLen;
                ans = 1;
            } else if (maxLen == rectLen) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countGoodRectangles(new int[][]{{2, 3}, {3, 7}, {4, 3}, {3, 7}}));
    }
}
