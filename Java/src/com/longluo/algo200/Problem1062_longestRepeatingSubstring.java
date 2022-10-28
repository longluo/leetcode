package com.longluo.algo200;

/**
 * 1062. 最长重复子串
 * <p>
 * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
 * <p>
 * 示例 1：
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 * <p>
 * 示例 2：
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 * <p>
 * 示例 3：
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 * <p>
 * 示例 4：
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 * <p>
 * 提示：
 * 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
 * 1 <= S.length <= 1500
 * <p>
 * https://leetcode.cn/problems/longest-repeating-substring/
 */
public class Problem1062_longestRepeatingSubstring {

    // BF time: O(n^3) space: O(1)
    public static int longestRepeatingSubstring_bf(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }

        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }

                int cnt = 0;
                for (; j + cnt < len; ) {
                    if (s.charAt(i + cnt) != s.charAt(j + cnt)) {
                        break;
                    }

                    cnt++;
                }

                maxLen = Math.max(maxLen, cnt);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + longestRepeatingSubstring_bf("abcd"));
        System.out.println("2 ?= " + longestRepeatingSubstring_bf("abbaba"));
        System.out.println("3 ?= " + longestRepeatingSubstring_bf("aabcaabdaab"));
    }
}
