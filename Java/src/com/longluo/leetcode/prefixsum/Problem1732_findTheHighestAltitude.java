package com.longluo.leetcode.prefixsum;

/**
 * 1732. 找到最高海拔
 * <p>
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * <p>
 * 示例 1：
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * <p>
 * 示例 2：
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * 提示：
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * <p>
 * https://leetcode.cn/problems/find-the-highest-altitude/
 */
public class Problem1732_findTheHighestAltitude {

    // Simulate time: O(n) space: O(1)
    public static int largestAltitude(int[] gain) {
        int len = gain.length;
        for (int i = 1; i < len; i++) {
            gain[i] += gain[i - 1];
        }

        int max = 0;
        for (int x : gain) {
            max = Math.max(max, x);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println("0 ?= " + largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}
