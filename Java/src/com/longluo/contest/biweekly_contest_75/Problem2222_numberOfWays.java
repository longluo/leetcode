package com.longluo.contest.biweekly_contest_75;

import java.util.ArrayList;
import java.util.List;

/**
 * 2222. 选择建筑的方案数
 * <p>
 * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
 * <p>
 * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
 * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
 * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
 * <p>
 * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
 * 请你返回可以选择 3 栋建筑的 有效方案数 。
 * <p>
 * 示例 1：
 * 输入：s = "001101"
 * 输出：6
 * 解释：
 * 以下下标集合是合法的：
 * - [0,2,4] ，从 "001101" 得到 "010"
 * - [0,3,4] ，从 "001101" 得到 "010"
 * - [1,2,4] ，从 "001101" 得到 "010"
 * - [1,3,4] ，从 "001101" 得到 "010"
 * - [2,4,5] ，从 "001101" 得到 "101"
 * - [3,4,5] ，从 "001101" 得到 "101"
 * 没有别的合法选择，所以总共有 6 种方法。
 * <p>
 * 示例 2：
 * 输入：s = "11100"
 * 输出：0
 * 解释：没有任何符合题意的选择。
 * <p>
 * 提示：
 * 3 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1' 。
 * <p>
 * https://leetcode.cn/problems/number-of-ways-to-select-buildings/
 */
public class Problem2222_numberOfWays {

    // TODO: 2022/6/2
    public static long numberOfWays(String s) {
        int len = s.length();
        List<int[]> houses = new ArrayList<>();
        char lastCh = s.charAt(0);
        int idx = 0;
        int cnt = 0;
        while (idx < len) {
            while (idx < len && s.charAt(idx) == lastCh) {
                idx++;
                cnt++;
            }

            if (idx < len) {
                houses.add(new int[]{lastCh - '0', cnt});
                lastCh = s.charAt(idx);
                cnt = 0;
            } else {
                houses.add(new int[]{lastCh - '0', cnt});
            }
        }

        if (houses.size() < 3) {
            return 0;
        }

        int size = houses.size();
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = houses.get(0)[1] * houses.get(1)[1] * houses.get(2)[1];
        for (int i = 3; i < size; i++) {
            dp[i] = dp[i - 1] * houses.get(i)[1] + dp[i - 2] * houses.get(i)[1];
        }

        return dp[size - 1];
    }

    public static void back(List<int[]> res, StringBuilder sb, boolean[] seen, String str) {
        if (sb.toString() == str) {

        }

    }

    public static void main(String[] args) {
        numberOfWays("001101");
        numberOfWays("111000");
    }
}
