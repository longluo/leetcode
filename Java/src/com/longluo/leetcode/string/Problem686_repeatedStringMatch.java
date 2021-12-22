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

    public static int repeatedStringMatch(String a, String b) {
        if (a.equals(b) || a.contains(b)) {
            return 1;
        }

        int ans = -1;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (char ch : a.toCharArray()) {
            mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
        }
        for (char ch : b.toCharArray()) {
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
        }
        if (mapB.size() > mapA.size()) {
            return -1;
        }
        for (Character ch : mapB.keySet()) {
            if (!mapA.containsKey(ch)) {
                return -1;
            } else {
                int num = mapB.get(ch).intValue() / mapA.get(ch).intValue();
                ans = Math.max(ans, num);
            }
        }

        String res = "";
        if (a.length() > b.length()) {
            ans = 2;
        }
        for (int i = 0; i < ans + 1; i++) {
            res += a;
            if (res.contains(b)) {
                if (i == ans) {
                    return ans + 1;
                } else {
                    return ans;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + repeatedStringMatch("a", "aa"));
        System.out.println("1 ?= " + repeatedStringMatch("a", "a"));
        System.out.println("3 ?= " + repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println("-1 ?= " + repeatedStringMatch("abc", "wxyz"));
        System.out.println("2 ?= " + repeatedStringMatch("abababaaba", "aabaaba"));
    }
}
