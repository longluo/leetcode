package com.longluo.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * <p>
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Problem438_findAllAnagramsInAString {

    // HashMap + SlidingWin time: O(m+(n−m)×Σ) space: O(2*Σ)
    public static List<Integer> findAnagrams_win(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) {
            return ans;
        }

        Map<Character, Integer> patMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            patMap.put(ch, patMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = left + pLen;

        // Sliding Window
        Map<Character, Integer> winMap = new HashMap<>();
        for (int i = left; i < right; i++) {
            char ch = s.charAt(i);
            winMap.put(ch, winMap.getOrDefault(ch, 0) + 1);
        }

        if (patMap.equals(winMap)) {
            ans.add(left);
        }

        while (right < sLen) {
            char chLeft = s.charAt(left);
            winMap.put(chLeft, winMap.get(chLeft) - 1);
            if (winMap.get(chLeft) == 0) {
                winMap.remove(chLeft);
            }

            char chRight = s.charAt(right);
            winMap.put(chRight, winMap.getOrDefault(chRight, 0) + 1);

            left++;
            right++;
            if (patMap.equals(winMap)) {
                ans.add(left);
            }
        }

        return ans;
    }

    // Count + SlidingWin time: O(m+(n−m)×Σ) space: O(Σ)
    public static List<Integer> findAnagrams_cnt(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) {
            return ans;
        }

        int[] pCnt = new int[26];
        // Sliding Window
        int[] wCnt = new int[26];

        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i) - 'a']++;
            wCnt[s.charAt(i) - 'a']++;
        }

        if (check(pCnt, wCnt)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // minus left
            wCnt[s.charAt(i) - 'a']--;
            // plus right
            wCnt[s.charAt(i + pLen) - 'a']++;
            if (check(pCnt, wCnt)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static boolean check(int[] pCnt, int[] wCnt) {
        for (int i = 0; i < 26; i++) {
            if (pCnt[i] != wCnt[i]) {
                return false;
            }
        }

        return true;
    }




    public static void main(String[] args) {
        System.out.println("[0, 6] ?= " + findAnagrams_win("cbaebabacd", "abc"));
        System.out.println("[0, 1, 2] ?= " + findAnagrams_win("abab", "ab"));

        System.out.println("[0, 6] ?= " + findAnagrams_cnt("cbaebabacd", "abc"));
        System.out.println("[0, 1, 2] ?= " + findAnagrams_cnt("abab", "ab"));
    }
}
