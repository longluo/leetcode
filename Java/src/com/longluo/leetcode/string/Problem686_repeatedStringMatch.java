package com.longluo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 686. 重复叠加字符串匹配
 * <p>
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * <p>
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= a.length <= 10^4
 * 1 <= b.length <= 10^4
 * a 和 b 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/repeated-string-match/
 */
public class Problem686_repeatedStringMatch {

    // HashMap time: O(n + m) space: O(26)
    public static int repeatedStringMatch_hashmap(String a, String b) {
        if (a.equals(b) || a.contains(b)) {
            return 1;
        }

        int min = 1;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (char ch : a.toCharArray()) {
            mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
        }
        for (char ch : b.toCharArray()) {
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
        }

        for (char ch : mapB.keySet()) {
            if (!mapA.containsKey(ch)) {
                return -1;
            } else {
                int times = mapB.get(ch) / mapA.get(ch);
                min = Math.max(min, times);
            }
        }

        StringBuilder res = new StringBuilder(a);
        for (int i = 2; i <= min + 1; i++) {
            res.append(a);
            if (res.toString().contains(b)) {
                return i;
            }
        }

        return -1;
    }

    // Count time: O(m + n) space: O(n)
    public static int repeatedStringMatch_cnt(String a, String b) {
        if (a.equals(b) || a.contains(b)) {
            return 1;
        }

        int[] cntA = new int[26];
        int[] cntB = new int[26];

        for (char ch : a.toCharArray()) {
            cntA[ch - 'a']++;
        }

        for (char ch : b.toCharArray()) {
            cntB[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cntB[i] > 0 && cntA[i] == 0) {
                return -1;
            }
        }

        int minRepeatTimes = Math.max(1, b.length() / a.length() + 1);

        StringBuilder res = new StringBuilder(a);
        for (int i = 2; i <= minRepeatTimes + 1; i++) {
            res.append(a);
            if (res.toString().contains(b)) {
                return i;
            }
        }

        return -1;
    }

    // Count Opt time: O(n) space: O(n)
    public static int repeatedStringMatch_cnt_opt(String a, String b) {
        if (a.equals(b) || a.contains(b)) {
            return 1;
        }

        int minRepeatTimes = Math.max(1, b.length() / a.length() + 1);

        StringBuilder res = new StringBuilder(a);
        for (int i = 2; i <= minRepeatTimes + 1; i++) {
            res.append(a);
            if (res.toString().contains(b)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + repeatedStringMatch_hashmap("abababaaba", "aabaaba"));
        System.out.println("3 ?= " + repeatedStringMatch_cnt("abcd", "cdabcdab"));

        System.out.println("2 ?= " + repeatedStringMatch_cnt("a", "aa"));
        System.out.println("1 ?= " + repeatedStringMatch_cnt("a", "a"));
        System.out.println("3 ?= " + repeatedStringMatch_cnt("abcd", "cdabcdab"));
        System.out.println("-1 ?= " + repeatedStringMatch_cnt("abc", "wxyz"));
    }
}
