package com.longluo.algo200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 * <p>
 * 给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "eceba", k = 2
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * <p>
 * 示例 2：
 * 输入：s = "aa", k = 1
 * 输出：2
 * 解释：满足题目要求的子串是 "aa" ，长度为 2 。
 * <p>
 * 提示：
 * 1 <= s.length <= 5 * 10^4
 * 0 <= k <= 50
 * <p>
 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class Problem340_lengthOfLongestSubstringKDistinct {

    // SlidingWin + HashMap time: O(n) space: O(n)
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0) {
            return 0;
        }

        int len = s.length();

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < len; j++) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                int cnt = map.getOrDefault(s.charAt(i), 0);
                if (cnt == 1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), cnt - 1);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + lengthOfLongestSubstringKDistinct("a", 1));
        System.out.println("2 ?= " + lengthOfLongestSubstringKDistinct("aa", 2));
        System.out.println("1 ?= " + lengthOfLongestSubstringKDistinct("ab", 1));
        System.out.println("3 ?= " + lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println("4 ?= " + lengthOfLongestSubstringKDistinct("abaccc", 2));
    }
}
