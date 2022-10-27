package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1531. 压缩字符串 II
 * <p>
 * 行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。
 * 例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
 * <p>
 * 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 * <p>
 * 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 * <p>
 * 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 * <p>
 * 示例 1：
 * 输入：s = "aaabcccd", k = 2
 * 输出：4
 * 解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3c3" ，长度是 4 。
 * <p>
 * 示例 2：
 * 输入：s = "aabbaa", k = 2
 * 输出：2
 * 解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
 * <p>
 * 示例 3：
 * 输入：s = "aaaaaaaaaaa", k = 0
 * 输出：3
 * 解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s 仅包含小写英文字母
 * <p>
 * https://leetcode.cn/problems/string-compression-ii/
 */
public class Problem1531_stringCompression_ii {

    // BF Backtracking time:
    // TLE
    public static int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        if (len == k) {
            return 0;
        }

        int minLen = stringCompression(s).length();

        if (k == 0) {
            return minLen;
        }

        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), s, 0, len - k);

        minLen = Integer.MAX_VALUE;
        for (String subStr : res) {
            minLen = Math.min(minLen, stringCompression(subStr).length());
        }

        return minLen;
    }

    private static void backtrack(List<String> res, StringBuilder path, String s, int start, int sum) {
        if (start == s.length()) {
            if (path.length() == sum) {
                res.add(path.toString());
            }

            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (path.length() > sum) {
                continue;
            }

            path.append(s.charAt(i));
            backtrack(res, path, s, i + 1, sum);
            path.deleteCharAt(path.length() - 1);

            backtrack(res, path, s, i + 1, sum);
        }
    }

    private static String stringCompression(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder(len);

        char prev = s.charAt(0);
        sb.append(prev);

        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == prev) {
                cnt++;
            } else {
                if (cnt > 1) {
                    sb.append(cnt);
                }

                cnt = 1;
                prev = s.charAt(i);
                sb.append(prev);
            }
        }

        if (cnt > 1) {
            sb.append(cnt);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
        System.out.println("4 ?= " + getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println("2 ?= " + getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println("5 ?= " + getLengthOfOptimalCompression("aaaaabaaaaafffwfff", 2));
    }
}
