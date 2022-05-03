package com.longluo.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 10^5
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * <p>
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Problem76_minimumWindowSubstring {

    // Sliding Win time: O(m^2*n^2) space: O(m + n)
    public static String minWindow_bf(String s, String t) {
        if (s.equals(t)) {
            return t;
        }

        int lenSrc = s.length();
        int lenTgt = t.length();
        if (lenSrc < lenTgt) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> winMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = lenTgt;
        for (int i = left; i < right; i++) {
            char ch = s.charAt(i);
            winMap.put(ch, winMap.getOrDefault(ch, 0) + 1);
        }

        while (left <= right - lenTgt && right <= lenSrc) {
            int ret = isContain(winMap, targetMap);
            if (ret == 0) {
                if ((right - left) < minLen) {
                    minLen = right - left;
                    ans = s.substring(left, right);
                }

                char ch = s.charAt(left);
                int count = winMap.getOrDefault(ch, 0);
                if (count > 1) {
                    winMap.put(ch, count - 1);
                } else {
                    winMap.remove(ch);
                }

                left++;
            } else {
                if (right < lenSrc) {
                    char ch = s.charAt(right);
                    winMap.put(ch, winMap.getOrDefault(ch, 0) + 1);
                    right++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    // if less, -1 more 1, just ok 0
    public static int isContain(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for (Map.Entry<Character, Integer> entry : mapB.entrySet()) {
            Character ch = entry.getKey();
            int cnt = entry.getValue();

            if (mapA.getOrDefault(ch, 0) < cnt) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + minWindow_bf("a", "a"));
        System.out.println(" ?= " + minWindow_bf("a", "aa"));
        System.out.println("BANC ?= " + minWindow_bf("ADOBECODEBANC", "ABC"));
    }
}
