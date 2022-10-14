package com.longluo.LCCUP;

import java.util.HashMap;
import java.util.Map;

/**
 * LCP 39. 无人机方阵
 * <p>
 * 在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
 * <p>
 * 调整无人机的位置布局
 * 切换无人机展示的灯光颜色
 * 给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，
 * 请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
 * <p>
 * 注意： 调整无人机的位置布局时无人机的位置可以随意变动。
 * <p>
 * 示例 1：
 * 输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]
 * 输出：1
 * 解释：
 * 最佳方案为
 * 将 [0,1] 处的无人机移动至 [0,0] 处；
 * 将 [0,0] 处的无人机移动至 [0,1] 处；
 * 将 [1,0] 处的无人机移动至 [1,1] 处；
 * 将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
 * 因此从source 到 target 所需要的最少灯光切换次数为 1。
 * <p>
 * 示例 2：
 * 输入：source = [[1,2,3],[3,4,5]], target = [[1,3,5],[2,3,4]]
 * 输出：0
 * 解释：
 * 仅需调整无人机的位置布局，便可完成图案切换。因此不需要无人机切换颜色
 * <p>
 * 提示：
 * n == source.length == target.length
 * m == source[i].length == target[i].length
 * 1 <= n, m <=100
 * 1 <= source[i][j], target[i][j] <=10^4
 * <p>
 * https://leetcode.cn/problems/0jQkd0/
 */
public class LCP39_minimumSwitchingTimes {

    // HashMap time: O(mn) space: O(mn)
    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        int m = source.length;
        int n = source[0].length;

        int ans = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = source[i][j];
                count.put(value, count.getOrDefault(value, 0) + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = target[i][j];
                int freq = count.getOrDefault(value, 0);
                if (freq > 1) {
                    count.put(value, freq - 1);
                } else if (freq == 1) {
                    count.remove(value);
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }

    // HashMap Opt time: O(mn) space: O(mn)
    public static int minimumSwitchingTimes_opt(int[][] source, int[][] target) {
        int m = source.length;
        int n = source[0].length;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int src = source[i][j];
                int tgt = target[i][j];
                count.put(src, count.getOrDefault(src, 0) + 1);
                count.put(tgt, count.getOrDefault(tgt, 0) - 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans += Math.abs(entry.getValue());
        }

        return ans / 2;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumSwitchingTimes(new int[][]{{1, 3}, {5, 4}}, new int[][]{{3, 1}, {6, 5}}));
        System.out.println("0 ?= " + minimumSwitchingTimes(new int[][]{{1, 2, 3}, {3, 4, 5}}, new int[][]{{1, 3, 5}, {2, 3, 4}}));

        System.out.println("1 ?= " + minimumSwitchingTimes_opt(new int[][]{{1, 3}, {5, 4}}, new int[][]{{3, 1}, {6, 5}}));
        System.out.println("0 ?= " + minimumSwitchingTimes_opt(new int[][]{{1, 2, 3}, {3, 4, 5}}, new int[][]{{1, 3, 5}, {2, 3, 4}}));
    }
}
