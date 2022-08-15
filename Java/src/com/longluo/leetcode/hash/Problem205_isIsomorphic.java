package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * https://leetcode.cn/problems/isomorphic-strings/
 */
public class Problem205_isIsomorphic {

    // HashMap time: O(n) space: O(n)
    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();

        Map<Character, Character> srcMap = new HashMap<>();
        Map<Character, Character> destMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!srcMap.containsKey(s.charAt(i))) {
                srcMap.put(s.charAt(i), t.charAt(i));
            }

            if (!destMap.containsKey(t.charAt(i))) {
                destMap.put(t.charAt(i), s.charAt(i));
            }
        }

        for (int i = 0; i < len; i++) {
            if (srcMap.get(s.charAt(i)) == t.charAt(i) && destMap.get(t.charAt(i)) == s.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isIsomorphic("egg", "add"));
        System.out.println("false ?= " + isIsomorphic("foo", "bar"));
        System.out.println("true ?= " + isIsomorphic("paper", "title"));
        System.out.println("false ?= " + isIsomorphic("ab", "aa"));
    }
}
