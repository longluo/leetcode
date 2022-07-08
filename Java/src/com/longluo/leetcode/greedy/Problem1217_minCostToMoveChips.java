package com.longluo.leetcode.greedy;

import java.util.*;

/**
 * 1217. 玩筹码
 * <p>
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * <p>
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 示例 1：
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * <p>
 * 示例 2：
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * <p>
 * 示例 3:
 * 输入：position = [1,1000000000]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class Problem1217_minCostToMoveChips {

    // Count + Map time: O(n) space: O(n)
    public static int minCostToMoveChips(int[] position) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int pos : position) {
            countMap.put(pos, countMap.getOrDefault(pos, 0) + 1);
        }

        int odd = 0;
        int even = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int pos = entry.getKey();
            int num = entry.getValue();
            if (pos % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }

        return Math.min(odd, even);
    }

    // Count time: O(n) space: O(1)
    public static int minCostToMoveChips_opt(int[] position) {
        int odd = 0;
        int even = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println("2 ?= " + minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        System.out.println("3 ?= " + minCostToMoveChips(new int[]{11, 1, 3, 2, 2, 4}));
        System.out.println("2 ?= " + minCostToMoveChips(new int[]{3, 3, 1, 2, 2}));

        System.out.println("2 ?= " + minCostToMoveChips_opt(new int[]{3, 3, 1, 2, 2}));
    }
}
