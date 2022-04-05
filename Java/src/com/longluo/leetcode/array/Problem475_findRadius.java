package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 475. 供暖器
 * <p>
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * <p>
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * <p>
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/heaters/
 */
public class Problem475_findRadius {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int len = houses.length;
        int num = heaters.length;
        int min = houses[0];
        int max = houses[len - 1];
        if (len <= 1 && num <= 1) {
            return Math.abs(min - heaters[0]);
        }
        if (num == 1) {
            return Math.max(Math.abs(min - heaters[0]), Math.abs(max - heaters[0]));
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int idx = houses[i];
            for (int j = 0; j < heaters.length; j++) {
                ans = Math.min(ans, Math.abs(idx - heaters[j]));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println("2 ?= " + findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println("3 ?= " + findRadius(new int[]{1, 5}, new int[]{2}));
    }
}
