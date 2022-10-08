package com.longluo.contest.LCCUP2022_Personal;

/**
 * LCP 61. 气温变化趋势
 * <p>
 * 力扣城计划在两地设立「力扣嘉年华」的分会场，气象小组正在分析两地区的气温变化趋势，对于第 i ~ (i+1) 天的气温变化趋势，将根据以下规则判断：
 * <p>
 * 若第 i+1 天的气温 高于 第 i 天，为 上升 趋势
 * 若第 i+1 天的气温 等于 第 i 天，为 平稳 趋势
 * 若第 i+1 天的气温 低于 第 i 天，为 下降 趋势
 * <p>
 * 已知 temperatureA[i] 和 temperatureB[i] 分别表示第 i 天两地区的气温。
 * 组委会希望找到一段天数尽可能多，且两地气温变化趋势相同的时间举办嘉年华活动。请分析并返回两地气温变化趋势相同的最大连续天数。
 * <p>
 * 即最大的 n，使得第 i~i+n 天之间，两地气温变化趋势相同
 * <p>
 * 示例 1：
 * 输入：
 * temperatureA = [21,18,18,18,31]
 * temperatureB = [34,32,16,16,17]
 * 输出：2
 * 解释：如下表所示， 第 2～4 天两地气温变化趋势相同，且持续时间最长，因此返回 4-2=2
 * <p>
 * 示例 2：
 * 输入：
 * temperatureA = [5,10,16,-6,15,11,3]
 * temperatureB = [16,22,23,23,25,3,-16]
 * 输出：3
 * <p>
 * 提示：
 * 2 <= temperatureA.length == temperatureB.length <= 1000
 * -20 <= temperatureA[i], temperatureB[i] <= 40
 * <p>
 * https://leetcode.cn/problems/6CE719/
 */
public class Problem1_temperatureTrend {

    // Simulate time: O(n) space: O(n)
    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length;

        int[] trendA = new int[len - 1];
        int[] trendB = new int[len - 1];

        for (int i = 1, j = 0; i < len; i++, j++) {
            if (temperatureA[i] == temperatureA[i - 1]) {
                trendA[j] = 0;
            } else if (temperatureA[i] > temperatureA[i - 1]) {
                trendA[j] = 1;
            } else {
                trendA[j] = -1;
            }

            if (temperatureB[i] == temperatureB[i - 1]) {
                trendB[j] = 0;
            } else if (temperatureB[i] > temperatureB[i - 1]) {
                trendB[j] = 1;
            } else {
                trendB[j] = -1;
            }
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            if (trendA[i] == trendB[i]) {
                cnt++;
            } else {
                cnt = 0;
            }

            max = Math.max(max, cnt);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17}));
    }
}
