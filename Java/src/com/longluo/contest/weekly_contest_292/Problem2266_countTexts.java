package com.longluo.contest.weekly_contest_292;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2266. 统计打字方案数
 * <p>
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * <p>
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * <p>
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * <p>
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * <p>
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 * <p>
 * 示例 2：
 * 输入：pressedKeys = "222222222222222222222222222222222222"
 * 输出：82876089
 * 解释：
 * 总共有 2082876103 种 Alice 可能发出的文字信息。
 * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
 * <p>
 * 提示：
 * 1 <= pressedKeys.length <= 10^5
 * pressedKeys 只包含数字 '2' 到 '9' 。
 * <p>
 * https://leetcode.cn/problems/count-number-of-texts/
 */
public class Problem2266_countTexts {

    // TODO: 2022/6/2  
    public static int countTexts(String pressedKeys) {
        int[] cnt = {3, 3, 3, 3, 3, 4, 3, 4};
        int MOD = 1_000_000_000;
        int len = pressedKeys.length();

        List<int[]> list = new ArrayList<>();
        int idx = 1;
        int count = 1;
        int num = pressedKeys.charAt(0) - '0';
        while (idx < len) {
            while (idx < len && (pressedKeys.charAt(idx) - '0') == num) {
                idx++;
                count++;
            }

            list.add(new int[]{num, count});
            if (idx < len) {
                num = pressedKeys.charAt(idx) - '0';
                count = 0;
            }
        }

        int size = list.size();
        int[] dp = new int[size];
        dp[0] = getCount(list.get(0)[0], list.get(0)[1], cnt) % MOD;
        for (int i = 1; i < size; i++) {
            int cur = getCount(list.get(i)[0], list.get(i)[1], cnt) % MOD;
            dp[i] = (dp[i - 1] * cur) % MOD;
        }

        return dp[size - 1];
    }

    public static int getCount(int digit, int len, int[] count) {
        if (len <= 2) {
            return len;
        }

        int MOD = 1_000_000_000;
        int maxCnt = count[digit - 2];
        int[] dp = new int[len + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= len; i++) {
            if (maxCnt > 3) {
                dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD + dp[i - 3] % MOD + dp[i - 4] % MOD;
            } else {
                dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD + dp[i - 3] % MOD;
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(countTexts("22233"));
        System.out.println(countTexts("222222222222222222222222222222222222"));
    }
}
