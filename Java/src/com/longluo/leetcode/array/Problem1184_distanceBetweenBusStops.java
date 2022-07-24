package com.longluo.leetcode.array;

/**
 * 1184. 公交站间的距离
 * <p>
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * 示例 1：
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * <p>
 * <p>
 * 示例 2：
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * <p>
 * 示例 3：
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/distance-between-bus-stops/
 */
public class Problem1184_distanceBetweenBusStops {

    // Simulate time: O(n) space: O(1)
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int x : distance) {
            sum += x;
        }

        int forwardDis = 0;

        if (start > destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }

        for (int i = start; i < destination; i++) {
            forwardDis += distance[i];
        }

        return Math.min(forwardDis, sum - forwardDis);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
    }
}
