package com.longluo.LCCUP.LCCUP_2022_Fall_Team;

/**
 * LCP 66. 最小展台数量
 * <p>
 * 力扣嘉年华将举办一系列展览活动，后勤部将负责为每场展览提供所需要的展台。
 * 已知后勤部得到了一份需求清单，记录了近期展览所需要的展台类型， demand[i][j] 表示第 i 天展览时第 j 个展台的类型。
 * 在满足每一天展台需求的基础上，请返回后勤部需要准备的 最小 展台数量。
 * <p>
 * 注意：
 * 同一展台在不同天中可以重复使用。
 * <p>
 * 示例 1：
 * 输入：demand = ["acd","bed","accd"]
 * 输出：6
 * 解释：
 * 第 0 天需要展台 a、c、d；
 * 第 1 天需要展台 b、e、d；
 * 第 2 天需要展台 a、c、c、d；
 * 因此，后勤部准备 abccde 的展台，可以满足每天的展览需求;
 * <p>
 * 示例 2：
 * 输入：demand = ["abc","ab","ac","b"]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= demand.length,demand[i].length <= 100
 * demand[i][j] 仅为小写字母
 * <p>
 * https://leetcode.cn/problems/600YaG/
 */
public class T1_LCP66_minNumBooths {

    // Count time: O(26*n) space: O(26)
    public static int minNumBooths(String[] demand) {
        if (demand == null || demand.length == 0) {
            return 0;
        }

        int len = demand.length;
        int[] count = new int[26];

        String first = demand[0];
        for (char ch : first.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 1; i < len; i++) {
            int[] sum = new int[26];
            String s = demand[i];
            for (char ch : s.toCharArray()) {
                sum[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (count[j] >= sum[j]) {
                    continue;
                }

                count[j] = sum[j];
            }
        }

        int ans = 0;
        for (int x : count) {
            ans += x;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + minNumBooths(new String[]{"acd", "bed", "accd"}));
    }
}
