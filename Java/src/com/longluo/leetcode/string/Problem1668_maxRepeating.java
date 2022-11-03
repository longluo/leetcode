package com.longluo.leetcode.string;

/**
 * 1668. 最大重复子字符串
 * <p>
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * 那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * <p>
 * 示例 2：
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * <p>
 * 示例 3：
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * <p>
 * 提示：
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/maximum-repeating-substring/
 */
public class Problem1668_maxRepeating {

    // API time: O(nk) space: O(1)
    public static int maxRepeating(String sequence, String word) {
        int sLen = sequence.length();
        int wLen = word.length();

        StringBuilder wordBuilder = new StringBuilder();

        int ans = 0;
        for (int i = 1; i <= sLen / wLen; i++) {
            wordBuilder.append(word);
            if (sequence.contains(wordBuilder)) {
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }

    // BF time: O(nk) space: O(1)
    public static int maxRepeating_bf(String sequence, String word) {
        int sLen = sequence.length();
        int wLen = word.length();

        int ans = 0;

        for (int i = 0; i < sLen; i++) {
            if (sequence.charAt(i) != word.charAt(0)) {
                continue;
            }

            for (int k = 1; k <= (sLen - i) / wLen; k++) {
                int j = 0;
                while (j < k * wLen && sequence.charAt(i + j) == word.charAt(j % wLen)) {
                    j++;
                }

                ans = Math.max(ans, j / wLen);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + maxRepeating("a", "a"));
        System.out.println("2 ?= " + maxRepeating("ababc", "ab"));
        System.out.println("1 ?= " + maxRepeating("ababc", "ba"));
        System.out.println("0 ?= " + maxRepeating("ababc", "ac"));
        System.out.println("5 ?= " + maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));

        System.out.println("1 ?= " + maxRepeating_bf("ababc", "ba"));
        System.out.println("5 ?= " + maxRepeating_bf("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
