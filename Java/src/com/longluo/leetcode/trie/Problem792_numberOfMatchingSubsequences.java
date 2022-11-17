package com.longluo.leetcode.trie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 792. 匹配子序列的单词数
 * <p>
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * <p>
 * Example 2:
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= s.length <= 5 * 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成
 * <p>
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class Problem792_numberOfMatchingSubsequences {

    // BF time: O(mn) space: O(1)
    // TLE
    public static int numMatchingSubseq_bf(String s, String[] words) {
        int len = s.length();

        int ans = 0;

        for (String word : words) {
            if (word.length() > len) {
                continue;
            }

            for (int i = 0, j = 0; i < word.length() && j < len; j++) {
                if (word.charAt(i) == s.charAt(j)) {
                    i++;
                }

                if (i == word.length()) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Count time: O(len + sum(len)) space: O(words.len)
    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new ArrayDeque<>());
        }

        for (String w : words) {
            map.get(w.charAt(0)).addLast(w);
        }

        int count = 0;
        for (char ch : s.toCharArray()) {
            Deque<String> deque = map.get(ch);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String w = deque.removeFirst();
                if (w.length() == 1) {
                    count++;
                } else {
                    map.get(w.charAt(1)).addLast(w.substring(1));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numMatchingSubseq_bf("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println("3 ?= " + numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
