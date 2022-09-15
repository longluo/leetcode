package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * https://leetcode.cn/problems/decode-ways/
 */
public class Problem91_decodeWays {

    // Backtrack time: O(2^n) space: O(n)
    // TLE
    public static int numDecodings_backtrack(String s) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, new StringBuilder(), s, 0);

        return ans.size();
    }

    private static void backtrack(List<String> res, StringBuilder path, String s, int idx) {
        int len = s.length();

        if (idx == len) {
            res.add(path.toString());
            return;
        }

        if (s.charAt(idx) == '0') {
            return;
        }

        int digit = s.charAt(idx) - '0' - 1;
        path.append((char) ('A' + digit));
        backtrack(res, path, s, idx + 1);
        path.deleteCharAt(path.length() - 1);

        if (idx < len - 1) {
            digit = Integer.parseInt(s.substring(idx, idx + 2));
            if (digit <= 26) {
                path.append((char) ('A' + digit - 1));
                backtrack(res, path, s, idx + 2);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    // DP time: O(n) space: O(n)
    public static int numDecodings_dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (i >= 2 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + numDecodings_backtrack("12"));
        System.out.println("3 ?= " + numDecodings_backtrack("226"));

        System.out.println("2 ?= " + numDecodings_dp("12"));
        System.out.println("3 ?= " + numDecodings_dp("226"));
        System.out.println("0 ?= " + numDecodings_dp("0"));
        System.out.println("0 ?= " + numDecodings_dp("06"));
        System.out.println("1 ?= " + numDecodings_dp("10"));
        System.out.println("1 ?= " + numDecodings_dp("2101"));
        System.out.println("5 ?= " + numDecodings_dp("1123")); // 1 1 2 3  11 2 3  1 12 3  1 1 23   11 23
    }
}
