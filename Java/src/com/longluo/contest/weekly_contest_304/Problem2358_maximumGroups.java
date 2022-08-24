package com.longluo.contest.weekly_contest_304;

/**
 * 2358. 分组的最大数量
 * <p>
 * 给你一个正整数数组 grades ，表示大学中一些学生的成绩。你打算将 所有 学生分为一些 有序 的非空分组，
 * 其中分组间的顺序满足以下全部条件：
 * <p>
 * 第 i 个分组中的学生总成绩 小于 第 (i + 1) 个分组中的学生总成绩，对所有组均成立（除了最后一组）。
 * 第 i 个分组中的学生总数 小于 第 (i + 1) 个分组中的学生总数，对所有组均成立（除了最后一组）。
 * 返回可以形成的 最大 组数。
 * <p>
 * 示例 1：
 * 输入：grades = [10,6,12,7,3,5]
 * 输出：3
 * 解释：下面是形成 3 个分组的一种可行方法：
 * - 第 1 个分组的学生成绩为 grades = [12] ，总成绩：12 ，学生数：1
 * - 第 2 个分组的学生成绩为 grades = [6,7] ，总成绩：6 + 7 = 13 ，学生数：2
 * - 第 3 个分组的学生成绩为 grades = [10,3,5] ，总成绩：10 + 3 + 5 = 18 ，学生数：3
 * 可以证明无法形成超过 3 个分组。
 * <p>
 * 示例 2：
 * 输入：grades = [8,8]
 * 输出：1
 * 解释：只能形成 1 个分组，因为如果要形成 2 个分组的话，会导致每个分组中的学生数目相等。
 * <p>
 * 提示：
 * 1 <= grades.length <= 105
 * 1 <= grades[i] <= 105
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/
 */
public class Problem2358_maximumGroups {

    // TODO: 2022/8/24  
    public static int maximumGroups(int[] grades) {

        return 0;
    }

    public static void main(String[] args) {

    }
}
