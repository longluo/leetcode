package com.longluo.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 336. 回文对
 * <p>
 * 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1：
 * 输入：words = ["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * <p>
 * 示例 2：
 * 输入：words = ["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 * <p>
 * 示例 3：
 * 输入：words = ["a",""]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 提示：
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/palindrome-pairs/
 */
public class Problem336_palindromePairs {

    // BF time: O(n^2*sum) space: O(n)
    // TLE
    public static List<List<Integer>> palindromePairs_bf(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = words.length;
        if (len <= 1) {
            return ans;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    String combineStr = words[i] + words[j];
                    if (isPalindrome(combineStr)) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);

                        ans.add(pair);
                    }
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[[0,1], [1,0], [3,2], [2,4]] ?= " + palindromePairs_bf(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }
}
