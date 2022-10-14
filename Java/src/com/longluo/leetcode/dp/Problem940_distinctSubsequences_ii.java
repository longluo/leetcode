package com.longluo.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 940. 不同的子序列 II
 * <p>
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * 示例 1：
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * <p>
 * 示例 2：
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * <p>
 * 示例 3：
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * <p>
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/distinct-subsequences-ii/
 */
public class Problem940_distinctSubsequences_ii {

    // BF Backtrack time: O(2^n) space: O(n)
    public static int distinctSubseqII_bf(String s) {
        int mod = 1_000_000_007;
        int len = s.length();

        char[] array = s.toCharArray();

        long ans = 0;
        for (int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            backtrack(set, new StringBuilder(), array, 0, i);
            ans += set.size();
            ans %= mod;
        }

        return (int) (ans % mod);
    }

    private static void backtrack(Set<String> res, StringBuilder path, char[] array, int idx, int len) {
        if (path.length() == len) {
            res.add(new String(path));
            return;
        }

        for (int i = idx; i < array.length; i++) {
            if (path.length() < len) {
                path.append(array[i]);
                backtrack(res, path, array, i + 1, len);
                path.deleteCharAt(path.length() - 1);

                backtrack(res, path, array, i + 1, len);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + distinctSubseqII_bf("abc"));
        System.out.println("6 ?= " + distinctSubseqII_bf("aba"));
    }
}
