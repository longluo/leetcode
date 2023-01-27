package com.longluo.contest.weekly_contest_298;

import java.util.*;

/**
 * 2309. 兼具大小写的最好英文字母
 * <p>
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。
 * 如果不存在满足条件的字母，则返回一个空字符串。
 * <p>
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * <p>
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * <p>
 * 示例 1：
 * 输入：s = "lEeTcOdE"
 * 输出："E"
 * 解释：
 * 字母 'E' 是唯一一个大写和小写形式都出现的字母。
 * <p>
 * 示例 2：
 * 输入：s = "arRAzFif"
 * 输出："R"
 * 解释：
 * 字母 'R' 是大写和小写形式都出现的最好英文字母。
 * 注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
 * <p>
 * 示例 3：
 * 输入：s = "AbCdEfGhIjK"
 * 输出：""
 * 解释：
 * 不存在大写和小写形式都出现的字母。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写和大写英文字母组成
 * <p>
 * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 */
public class Problem2309_greatestLetter {

    // HashSet time: O(n) space: O(n)
    public static String greatestLetter(String s) {
        List<Character> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (set.contains(Character.toLowerCase(ch))) {
                    res.add(ch);
                }

                set.add(ch);
            } else {
                if (set.contains(Character.toUpperCase(ch))) {
                    res.add(Character.toUpperCase(ch));
                }

                set.add(ch);
            }
        }

        if (res.size() == 0) {
            return "";
        }

        Collections.sort(res, (o1, o2) -> o2 - o1);

        return Character.toUpperCase(res.get(0)) + "";
    }

    // HashSet time: O(n) space: O(n)
    public static String greatestLetter_hash(String s) {
        char ans = ' ';

        Set<Character> seen = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (seen.contains(ch)) {
                continue;
            }

            if (Character.isLowerCase(ch)) {
                char upper = Character.toUpperCase(ch);
                if (seen.contains(upper)) {
                    if (upper > ans) {
                        ans = upper;
                    }
                }
            } else {
                if (seen.contains(Character.toLowerCase(ch))) {
                    if (ch > ans) {
                        ans = ch;
                    }
                }
            }

            seen.add(ch);
        }

        return ans == ' ' ? "" : ans + "";
    }

    public static void main(String[] args) {
        System.out.println("E ?= " + greatestLetter("lEeTcOdE"));
        System.out.println("R ?= " + greatestLetter("arRAzFif"));
        System.out.println(" ?= " + greatestLetter("AbCdEfGhIjK"));

        System.out.println("E ?= " + greatestLetter_hash("lEeTcOdE"));
        System.out.println("R ?= " + greatestLetter_hash("arRAzFif"));
        System.out.println(" ?= " + greatestLetter_hash("AbCdEfGhIjK"));
    }
}
