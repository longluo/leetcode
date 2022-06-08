package com.longluo.studyplan.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * 467. 环绕字符串中唯一的子字符串
 * <p>
 * 把字符串 s 看作 "abcdefghijklmnopqrstuvwxyz" 的无限环绕字符串，所以 s 看起来是这样的：
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." 。
 * 现在给定另一个字符串 p 。返回 s 中 不同 的 p 的 非空子串 的数量 。
 * <p>
 * 示例 1：
 * 输入：p = "a"
 * 输出：1
 * 解释：字符串 s 中只有 p 的一个 "a" 子字符。
 * <p>
 * 示例 2：
 * 输入：p = "cac"
 * 输出：2
 * 解释：字符串 s 中只有 p 的两个子串 ("a", "c") 。
 * <p>
 * 示例 3：
 * 输入：p = "zab"
 * 输出：6
 * 解释：在字符串 s 中有 p 的六个子串 ("z", "a", "b", "za", "ab", "zab") 。
 * <p>
 * 提示：
 * 1 <= p.length <= 10^5
 * p 由小写英文字母组成
 * <p>
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 */
public class Problem467_uniqueSubstringsinWraparoundString {

    // BF time: O(n^3) space: O(n)
    // TLE
    public static int findSubstringInWraproundString_bf(String p) {
        int ans = 0;
        int len = p.length();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String subStr = p.substring(i, j);
                if (subStr.length() == 1) {
                    if (!seen.contains(subStr)) {
                        ans++;
                        seen.add(subStr);
                    }

                    continue;
                }

                boolean flag = true;
                int startIdx = subStr.charAt(0) - 'a';
                for (int k = 1; k < subStr.length(); k++) {
                    char ch = subStr.charAt(k);
                    startIdx = (startIdx + 1) % 26;
                    if (ch - 'a' != startIdx) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    if (!seen.contains(subStr)) {
                        ans++;
                        seen.add(subStr);
                    }
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    // DP time: O(n) space: O(26)
    public static int findSubstringInWraproundString_dp(String p) {
        int len = p.length();
        int[] dp = new int[26];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = p.charAt(i);
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                count++;
            } else {
                count = 1;
            }

            dp[ch - 'a'] = Math.max(dp[ch - 'a'], count);
        }

        int ans = 0;
        for (int x : dp) {
            ans += x;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findSubstringInWraproundString_bf("a"));
        System.out.println("2 ?= " + findSubstringInWraproundString_bf("cac"));
        System.out.println("6 ?= " + findSubstringInWraproundString_bf("zab"));
        System.out.println("3 ?= " + findSubstringInWraproundString_bf("abaab"));

        System.out.println("6 ?= " + findSubstringInWraproundString_dp("zab"));
        System.out.println("3 ?= " + findSubstringInWraproundString_dp("abaab"));
    }
}
