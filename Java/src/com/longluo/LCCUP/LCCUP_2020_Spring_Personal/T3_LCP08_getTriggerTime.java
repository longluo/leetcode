package com.longluo.LCCUP.LCCUP_2020_Spring_Personal;

import java.util.Arrays;

/**
 * LCP 08. 剧情触发时间
 * <p>
 * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，
 * 分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
 * <p>
 * 随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。
 * 这个二维数组的每个元素是一个长度为 3 的一维数组，
 * 例如 [[1,2,1}, {3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
 * <p>
 * 所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，
 * 对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
 * <p>
 * 根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
 * <p>
 * 示例 1：
 * 输入： increase = [[2,8,4}, {2,5,0}, {10,9,8]]
 * requirements = [[2,11,3}, {15,10,7}, {9,17,12}, {8,1,14]]
 * 输出: [2,-1,3,-1]
 * 解释：
 * 初始时，C = 0，R = 0，H = 0
 * 第 1 天，C = 2，R = 8，H = 4
 * 第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
 * 第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
 * 剧情 1 和 3 无法触发。
 * <p>
 * 示例 2：
 * 输入： increase = [[0,4,5}, {4,8,8}, {8,6,1}, {10,10,0]]
 * requirements = [[12,11,16}, {20,2,6}, {9,2,6}, {10,18,3}, {8,14,9]]
 * 输出: [-1,4,3,3,3]
 * <p>
 * 示例 3：
 * 输入： increase = [[1,1,1]] requirements = [[0,0,0]]
 * 输出: [0]
 * <p>
 * 限制：
 * 1 <= increase.length <= 10000
 * 1 <= requirements.length <= 100000
 * 0 <= increase[i] <= 10
 * 0 <= requirements[i] <= 100000
 * <p>
 * https://leetcode.cn/problems/ju-qing-hong-fa-shi-jian/
 */
public class T3_LCP08_getTriggerTime {

    // BF time: O(mn) space: O(n)
    // TLE
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = requirements.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int civil = 0;
        int resource = 0;
        int human = 0;

        for (int i = 0; i <= increase.length; i++) {

            for (int j = 0; j < n; j++) {
                if (ans[j] >= 0) {
                    continue;
                }

                if (civil >= requirements[j][0]
                        && resource >= requirements[j][1]
                        && human >= requirements[j][2]) {
                    ans[j] = i;
                }
            }

            if (i == increase.length) {
                break;
            }

            int[] item = increase[i];
            civil += item[0];
            resource += item[1];
            human += item[2];
        }

        return ans;
    }

    // BinarySearch time: O(nlogm) space: O(m)
    public static int[] getTriggerTime_bs(int[][] increase, int[][] requirements) {
        int m = increase.length;

        int[][] sums = new int[m + 1][3];

        for (int i = 0; i < m; i++) {
            sums[i + 1][0] = increase[i][0] + sums[i][0];
            sums[i + 1][1] = increase[i][1] + sums[i][1];
            sums[i + 1][2] = increase[i][2] + sums[i][2];
        }

        int n = requirements.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int lowBound = binarySearch(sums, requirements[i][0]);
            if (lowBound < 0) {
                continue;
            }

            for (int j = lowBound; j < m + 1; j++) {
                if (sums[j][1] >= requirements[i][1] && sums[j][2] >= requirements[i][2]) {
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }

    private static int binarySearch(int[][] array, int target) {
        int m = array.length;

        if (array[m - 1][0] < target) {
            return -1;
        } else if (array[0][0] >= target) {
            return 0;
        }

        int left = 0;
        int right = m - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("[2, -1, 3, -1] ?= " + Arrays.toString(getTriggerTime(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}})));
        System.out.println("[0] ?= " + Arrays.toString(getTriggerTime(new int[][]{{1, 1, 1}}, new int[][]{{0, 0, 0}})));

        System.out.println("[2, -1, 3, -1] ?= " + Arrays.toString(getTriggerTime_bs(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}})));
        System.out.println("[0] ?= " + Arrays.toString(getTriggerTime_bs(new int[][]{{1, 1, 1}}, new int[][]{{0, 0, 0}})));
    }
}
