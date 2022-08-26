package com.longluo.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. 替换后的最长重复字符
 * <p>
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * <p>
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 仅由大写英文字母组成
 * 0 <= k <= s.length
 * <p>
 * https://leetcode.cn/problems/longest-repeating-character-replacement/
 */
public class Problem424_longestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }

    // HashMap time: O(n) space: O(26)
    public static int characterReplacement_hashmap(String s, int k) {
        int len = s.length();
        int max = 1;
        Map<Character, Integer> cntMap = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < len) {
            char ch = s.charAt(right);
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            max = Math.max(max, cntMap.get(ch));
            if (right - left + 1 - max > k) {
                cntMap.put(s.charAt(left), cntMap.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
        }

        return right - left;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + characterReplacement("ABAB", 2));
        System.out.println("4 ?= " + characterReplacement("AABABBA", 1));
        System.out.println("4 ?= " + characterReplacement_hashmap("AABABBA", 1));
    }
}
