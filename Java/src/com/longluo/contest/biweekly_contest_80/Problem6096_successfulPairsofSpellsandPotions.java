package com.longluo.contest.biweekly_contest_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6096. 咒语和药水的成功对数
 * <p>
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * <p>
 * 示例 1：
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * <p>
 * 示例 2：
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * <p>
 * 提示：
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10^5
 * 1 <= spells[i], potions[i] <= 10^5
 * 1 <= success <= 10^10
 * <p>
 * https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/
 */
public class Problem6096_successfulPairsofSpellsandPotions {

    // BF time: O(mn) space: O(n)
    // TLE
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if ((long) spell * potions[j] >= success) {
                    cnt++;
                }
            }

            res[i] = cnt;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[4, 0, 3] ?= " + Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println("[3, 0, 3] ?= " + Arrays.toString(successfulPairs(new int[]{15, 8, 19}, new int[]{38, 36, 23}, 328)));
    }
}
