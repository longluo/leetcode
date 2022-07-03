package com.longluo.leetcode.bitmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 318. 最大单词长度乘积
 * <p>
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * <p>
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/
 */
public class Problem318_maxProduct {

    // BF time: O(L + 26 * n^2) space: O(n)
    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }

        int len = words.length;
        boolean[][] cnt = new boolean[len][26];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                cnt[i][ch - 'a'] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (cnt[i][k] && cnt[j][k]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    // Bit time: O(L + 26 * n^2) space: O(n)
    public static int maxProduct_bit(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }

        int len = words.length;
        int[] masks = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    // Bit Opt time: O(L + 26 * n^2) space: O(n)
    public static int maxProduct_bit_opt(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }

        int len = words.length;
        Map<Integer, Integer> maskMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            int mask = 0;
            for (int j = 0; j < wordLen; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLen > maskMap.getOrDefault(mask, 0)) {
                maskMap.put(mask, wordLen);
            }
        }

        int ans = 0;
        Set<Integer> maskSet = maskMap.keySet();
        for (int mask1 : maskSet) {
            int len1 = maskMap.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int len2 = maskMap.get(mask2);
                    ans = Math.max(ans, len1 * len2);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("16 ?= " + maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println("16 ?= " + maxProduct_bit(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println("16 ?= " + maxProduct_bit_opt(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}
