package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= pattern.length <= 300
 * pattern只包含小写英文字母
 * 1 <= s.length <= 3000
 * s只包含小写英文字母和' '
 * s不包含 任何前导或尾随对空格
 * s中每个单词都被 单个空格 分隔
 * <p>
 * https://leetcode.cn/problems/word-pattern/
 */
public class Problem290_wordPattern {

    // Hash + Regex time: O(n) space: O(n)
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] words = s.split("\\s+");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (!map.containsValue(words[i])) {
                    map.put(pattern.charAt(i), words[i]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // BF + Hash time: O(n) space: O(n)
    public static boolean wordPattern_hash(String pattern, String s) {
        int p = 0;
        int q = 0;
        Map<Character, String> map = new HashMap<>();
        int start = 0;
        while (p < pattern.length() && q < s.length()) {
            start = q;
            while (q < s.length() && s.charAt(q) != ' ') {
                q++;
            }

            char ch = pattern.charAt(p);
            String word = s.substring(start, q);
            if (!map.containsKey(ch)) {
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(pattern.charAt(p), word);
            } else {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            }

            p++;
            q++;
        }

        if (p < pattern.length() || q < s.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + wordPattern("abba", "dog cat cat dog"));
        System.out.println("false ?= " + wordPattern("abba", "dog cat cat fish"));
        System.out.println("false ?= " + wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("false ?= " + wordPattern("abba", "dog dog dog dog"));

        System.out.println("true ?= " + wordPattern_hash("abba", "dog cat cat dog"));
        System.out.println("false ?= " + wordPattern_hash("abba", "dog dog dog dog"));
        System.out.println("false ?= " + wordPattern_hash("aaa", "aa aa aa aa"));
    }
}
