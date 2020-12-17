package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 290. 单词规律
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
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Problem290_wordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> wordMap = new HashMap<>();
        String[] words = s.split("\\ ");
        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(pattern.charAt(i))) {
                if (wordMap.get(pattern.charAt(i)).equals(words[i])) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!wordMap.containsValue(words[i])) {
                    wordMap.put(pattern.charAt(i), words[i]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + wordPattern("abba", "dog cat cat dog"));
        System.out.println("false ?= " + wordPattern("abba", "dog cat cat fish"));
        System.out.println("false ?= " + wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("false ?= " + wordPattern("abba", "dog dog dog dog"));
    }
}
