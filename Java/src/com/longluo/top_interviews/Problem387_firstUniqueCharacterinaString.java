package com.longluo.top_interviews;

import java.util.*;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Problem387_firstUniqueCharacterinaString {

    // HashMap time: O(n) space: O(n)
    public static int firstUniqChar(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // BF time: O(n^2) space: O(1)
    public static int firstUniqChar_bf(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            boolean isExist = false;
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == ch && i != j) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                return i;
            }
        }

        return -1;
    }

    // Count time: O(n) space: O(n)
    public static int firstUniqChar_cnt(String s) {
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + firstUniqChar(""));

        System.out.println("-1 ?= " + firstUniqChar_bf("aabb"));
        System.out.println("-1 ?= " + firstUniqChar_cnt("aabb"));

        System.out.println("0 ?= " + firstUniqChar("leetcode"));
        System.out.println("0 ?= " + firstUniqChar_bf("leetcode"));
        System.out.println("0 ?= " + firstUniqChar_cnt("leetcode"));

        System.out.println("2 ?= " + firstUniqChar("loveleetcode"));
        System.out.println("2 ?= " + firstUniqChar_bf("loveleetcode"));
    }
}
