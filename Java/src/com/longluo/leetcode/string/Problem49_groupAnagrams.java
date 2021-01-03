package com.longluo.leetcode.string;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Problem49_groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                counts[array[i] - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                sb.append((char)('a' + i));
                sb.append(counts[i]);
            }
            
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
}
