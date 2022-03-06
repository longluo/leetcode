package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2100. 适合打劫银行的日子
 * <p>
 * 你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
 * <p>
 * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
 * <p>
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天警卫数目都是非递增的。
 * 第 i 天后连续 time 天警卫数目都是非递减的。
 * 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 * <p>
 * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 * <p>
 * 示例 1：
 * 输入：security = [5,3,3,3,5,6,2], time = 2
 * 输出：[2,3]
 * 解释：
 * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
 * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
 * 没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
 * <p>
 * 示例 2：
 * 输入：security = [1,1,1,1,1], time = 0
 * 输出：[0,1,2,3,4]
 * 解释：
 * 因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
 * <p>
 * 示例 3：
 * 输入：security = [1,2,3,4,5,6], time = 2
 * 输出：[]
 * 解释：
 * 没有任何一天的前 2 天警卫数目是非递增的。
 * 所以没有适合打劫银行的日子，返回空数组。
 * <p>
 * 示例 4：
 * 输入：security = [1], time = 5
 * 输出：[]
 * 解释：
 * 没有日子前面和后面有 5 天时间。
 * 所以没有适合打劫银行的日子，返回空数组。
 * <p>
 * 提示：
 * 1 <= security.length <= 10^5
 * 0 <= security[i], time <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 */
public class Problem2100_findGoodDaysToRobTheBank {

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        if (security == null || security.length <= time) {
            return ans;
        }

        int len = security.length;
        for (int i = time; i < len - time; i++) {
            boolean flag = true;
            for (int j = i; j >= i - time; j--) {
                if (j - 1 >= i - time && security[j] > security[j - 1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int j = i; j <= i + time; j++) {
                    if (j + 1 <= i + time && security[j] > security[j + 1]) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static List<Integer> goodDaysToRobBank_dp(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int len = security.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            if (i >= 1 && security[i] >= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }

            if (len - i - 2 >= 0 && security[len - 1 - i] <= security[len - i - 2]) {
                right[len - i - 2] = right[len - 1 - i] + 1;
            }
        }

        for (int i = time; i < len - time; i++) {
            if (left[i] <= i && i >= right[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] ?= " + goodDaysToRobBank_dp(new int[]{5, 3, 3, 3, 5, 6, 2}, 2).toString());
    }
}
