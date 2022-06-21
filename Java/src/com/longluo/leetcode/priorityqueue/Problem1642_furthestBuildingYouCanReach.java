package com.longluo.leetcode.priorityqueue;

import java.util.PriorityQueue;

/**
 * 1642. 可以到达的最远建筑
 * <p>
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * <p>
 * 示例 1：
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * <p>
 * 示例 2：
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 * <p>
 * 示例 3：
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 * <p>
 * 提示：
 * 1 <= heights.length <= 10^5
 * 1 <= heights[i] <= 10^6
 * 0 <= bricks <= 10^9
 * 0 <= ladders <= heights.length
 * <p>
 * https://leetcode.cn/problems/furthest-building-you-can-reach/
 */
public class Problem1642_furthestBuildingYouCanReach {

    // PQ time: O(nlogl) space: O(l)
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;

        PriorityQueue<Integer> gaps = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int deltaHeight = heights[i + 1] - heights[i];
            if (deltaHeight > 0) {
                gaps.offer(deltaHeight);
                if (gaps.size() > ladders) {
                    sum += gaps.poll();
                }

                if (sum > bricks) {
                    return i;
                }
            }
        }

        return len - 1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println("7 ?= " + furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }
}
