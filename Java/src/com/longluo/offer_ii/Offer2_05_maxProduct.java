package com.longluo.offer_ii;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * <p>
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * <p>
 * https://leetcode-cn.com/problems/aseY1I/
 */
public class Offer2_05_maxProduct {

    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }

        int ans = 0;
        int n = words.length;
        boolean[][] flags = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                flags[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }

                if (k == 26) {
                    int product = words[i].length() * words[j].length();
                    ans = Math.max(ans, product);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("16 ?= " + maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"}));
        System.out.println("4 ?= " + maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println("0 ?= " + maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
