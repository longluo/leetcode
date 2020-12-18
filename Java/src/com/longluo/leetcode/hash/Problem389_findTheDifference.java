package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s和t只包含小写字母
 */
public class Problem389_findTheDifference {

    public static char findTheDifference(String s, String t) {
        if (s.length() != t.length() - 1) {
            return ' ';
        }

        Map<Character, Integer> srcMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            srcMap.put(ch, srcMap.getOrDefault(ch, 0) + 1);
        }

        char ans = ' ';
        for (Character ch : t.toCharArray()) {
            if (srcMap.containsKey(ch)) {
                if (srcMap.get(ch) > 1) {
                    srcMap.put(ch, srcMap.get(ch) - 1);
                } else {
                    srcMap.remove(ch);
                }
            } else {
                return ch;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("e ?= " + findTheDifference("abcd", "abcde"));
        System.out.println("y ?= " + findTheDifference("", "y"));
        System.out.println("a ?= " + findTheDifference("a", "aa"));
        System.out.println("a ?= " + findTheDifference("ae", "aea"));
    }
}
