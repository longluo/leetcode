package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * <p>
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），
 * 并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p>
 * 示例 2：
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p>
 * 示例 3：
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p>
 * 示例 4：
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class Problem1790_areAlmostEqual {

    // HashMap time: O(2*n) space: O(n)
    public static boolean areAlmostEqual_hash(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int cnt = 2;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (!map1.getOrDefault(ch1, 0).equals(map2.getOrDefault(ch1, 0))
                    || !map1.getOrDefault(ch2, 0).equals(map2.getOrDefault(ch2, 0))) {
                return false;
            }
            if (ch1 != ch2) {
                cnt--;
            }
        }

        return cnt >= 0;
    }

    // Count time: O(2*n) space: O(26) = O(1)
    public static boolean areAlmostEqual_cnt(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        int swap = 2;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (cnt1[ch1 - 'a'] != cnt2[ch1 - 'a'] || cnt1[ch2 - 'a'] != cnt2[ch2 - 'a']) {
                return false;
            }
            if (ch1 != ch2) {
                swap--;
            }
        }

        return swap >= 0;
    }

    // Record Chars time: O(n) space: O(1)
    public static boolean areAlmostEqual_record(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] diffChars = new char[2];
        int swap = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }

            if (swap == 0) {
                swap++;
                diffChars[0] = s1.charAt(i);
                diffChars[1] = s2.charAt(i);
            } else if (swap == 1) {
                swap++;
                if (s1.charAt(i) != diffChars[1] || s2.charAt(i) != diffChars[0]) {
                    return false;
                }
            } else if (swap >= 2) {
                return false;
            }
        }

        return swap == 0 || swap == 2;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + areAlmostEqual_hash("bank", "kanb"));
        System.out.println("false ?= " + areAlmostEqual_hash("aa", "ac"));
        System.out.println("false ?= " + areAlmostEqual_hash("abca", "abcc"));

        System.out.println("false ?= " + areAlmostEqual_cnt("aa", "ac"));
        System.out.println("false ?= " + areAlmostEqual_record("aa", "ac"));
        System.out.println("false ?= " + areAlmostEqual_record("qgqeg", "gqgeq"));
    }
}
