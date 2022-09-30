package com.longluo.lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.01. 判定字符是否唯一
 * <p>
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * <p>
 * 限制：
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * https://leetcode.cn/problems/is-unique-lcci/
 */
public class Lcci_01_01_isUnique {

    // HashMap time: O(n) space: O(n)
    public static boolean isUnique_hashmap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > 1) {
                return false;
            }
        }

        return true;
    }

    // Count time: O(n) space: O(26)
    public static boolean isUnique_count(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            if (count[ch - 'a'] > 1) {
                return false;
            }
        }

        return true;
    }

    // Sort time: O(nlogn) space: O(n)
    public static boolean isUnique_sort(String s) {
        char[] array = s.toCharArray();

        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // BF time: O(n^2) space: O(1)
    public static boolean isUnique_bf(String s) {
        if (s.length() > 26) {
            return false;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Bit time: O(n) space: O(1)
    public static boolean isUnique(String s) {
        if (s.length() > 26) {
            return false;
        }

        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            int shift = s.charAt(i) - 'a';
            if ((bit & (1 << shift)) > 0) {
                return false;
            }

            bit |= 1 << shift;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isUnique_hashmap("leetcode"));
        System.out.println("true ?= " + isUnique_hashmap("abc"));

        System.out.println("true ?= " + isUnique_count("abc"));

        System.out.println("true ?= " + isUnique_sort("abc"));

        System.out.println("true ?= " + isUnique_bf("abc"));

        System.out.println("true ?= " + isUnique("abc"));
    }
}
