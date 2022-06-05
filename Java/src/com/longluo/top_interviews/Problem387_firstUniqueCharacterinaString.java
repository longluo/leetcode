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
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
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

    public static void main(String[] args) {
        System.out.println("-1 ?= " + firstUniqChar(""));

        System.out.println("-1 ?= " + firstUniqChar_bf("aabb"));

        System.out.println("0 ?= " + firstUniqChar("leetcode"));
        System.out.println("0 ?= " + firstUniqChar_bf("leetcode"));

        System.out.println("2 ?= " + firstUniqChar("loveleetcode"));
        System.out.println("2 ?= " + firstUniqChar_bf("loveleetcode"));
    }
}
