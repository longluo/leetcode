package com.longluo.lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * <p>
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
public class Lcci_01_02_checkPermutation {

    // HashMap time: O(n) space: O(n)
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }

        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            if (!map2.containsKey(ch) || map2.getOrDefault(ch, 0) != freq) {
                return false;
            }
        }

        return true;
    }

    // Sort time: O(nlogn) space: O(n)
    public static boolean CheckPermutation_sort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + CheckPermutation("abc", "bca"));
        System.out.println("false ?= " + CheckPermutation("abc", "bad"));

        System.out.println("false ?= " + CheckPermutation_sort("abc", "bad"));
    }
}
