package com.longluo.contest.biweekly_contest_78;

/**
 * 6069. 最大波动的子字符串
 * <p>
 * 字符串的 波动 定义为子字符串中出现次数 最多 的字符次数与出现次数 最少 的字符次数之差。
 * <p>
 * 给你一个字符串 s ，它只包含小写英文字母。请你返回 s 里所有 子字符串的 最大波动 值。
 * <p>
 * 子字符串 是一个字符串的一段连续字符序列。
 * <p>
 * 示例 1：
 * 输入：s = "aababbb"
 * 输出：3
 * 解释：
 * 所有可能的波动值和它们对应的子字符串如以下所示：
 * - 波动值为 0 的子字符串："a" ，"aa" ，"ab" ，"abab" ，"aababb" ，"ba" ，"b" ，"bb" 和 "bbb" 。
 * - 波动值为 1 的子字符串："aab" ，"aba" ，"abb" ，"aabab" ，"ababb" ，"aababbb" 和 "bab" 。
 * - 波动值为 2 的子字符串："aaba" ，"ababbb" ，"abbb" 和 "babb" 。
 * - 波动值为 3 的子字符串 "babbb" 。
 * 所以，最大可能波动值为 3 。
 * <p>
 * 示例 2：
 * 输入：s = "abcde"
 * 输出：0
 * 解释：
 * s 中没有字母出现超过 1 次，所以 s 中每个子字符串的波动值都是 0 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s  只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/substring-with-largest-variance/
 */
public class Problem6069_substringWithLargestVariance {

    public int largestVariance(String s) {

        return 0;
    }

    public static void main(String[] args) {

    }
}
