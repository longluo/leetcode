package com.longluo.contest.LCCUP_2023_Spring_Personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCCUP'23 力扣杯春季编程大赛 - 个人赛
 *
 * https://leetcode.cn/circle/discuss/ByQDEU/
 */

/**
 * LCP 72. 补给马车
 * <p>
 * 远征队即将开启未知的冒险之旅，不过在此之前，将对补给车队进行最后的检查。
 * <p>
 * supplies[i] 表示编号为 i 的补给马车装载的物资数量。
 * 考虑到车队过长容易被野兽偷袭，他们决定将车队的长度变为原来的一半（向下取整），计划为：
 * <p>
 * 找出车队中 物资之和最小 两辆 相邻 马车，将它们车辆的物资整合为一辆。
 * 若存在多组物资之和相同的马车，则取编号最小的两辆马车进行整合；
 * 重复上述操作直到车队长度符合要求。
 * <p>
 * 请返回车队长度符合要求后，物资的分布情况。
 * <p>
 * 示例 1：
 * 输入：supplies = [7,3,6,1,8]
 * 输出：[10,15]
 * 解释：
 * 第 1 次合并，符合条件的两辆马车为 6,1，合并后的车队为 [7,3,7,8]；
 * 第 2 次合并，符合条件的两辆马车为 (7,3) 和 (3,7)，取编号最小的 (7,3)，合并后的车队为 [10,7,8]；
 * 第 3 次合并，符合条件的两辆马车为 7,8，合并后的车队为 [10,15]；
 * 返回 [10,15]
 * <p>
 * 示例 2：
 * 输入：supplies = [1,3,1,5]
 * 输出：[5,5]
 * 解释：
 * 2 <= supplies.length <= 1000
 * 1 <= supplies[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/hqCnmP/
 */
public class Problem1_supplyWagon {

    // BF time: O(n^2) space: O(n)
    public static int[] supplyWagon(int[] supplies) {
        int n = supplies.length;

        List<Integer> res = new ArrayList<>();

        for (int x : supplies) {
            res.add(x);
        }

        while (res.size() > n / 2) {
            int idx = 0;
            int min = res.get(0) + res.get(1);
            for (int i = 0; i < res.size() - 1; i++) {
                int sum = res.get(i) + res.get(i + 1);
                if (sum < min) {
                    min = sum;
                    idx = i;
                }
            }

            res.set(idx, min);
            res.remove(idx + 1);
        }

        int[] ans = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[10, 15] ?= " + Arrays.toString(supplyWagon(new int[]{7, 3, 6, 1, 8})));
        System.out.println("[5, 5] ?= " + Arrays.toString(supplyWagon(new int[]{1, 3, 1, 5})));
    }
}
