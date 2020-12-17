package com.longluo.offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 在字符串s中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
public class Offer50_firstUniqChar {

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("b ?= " + firstUniqChar("abaccdeff"));
        System.out.println(" ?= " + firstUniqChar(" "));
        System.out.println("l ?= " + firstUniqChar("leetcode"));
    }
}
