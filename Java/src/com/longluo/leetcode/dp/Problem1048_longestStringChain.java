package com.longluo.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. 最长字符串链
 * <p>
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 * <p>
 * 示例 1：
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * <p>
 * 示例 2:
 * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * 输出：5
 * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * <p>
 * 示例 3:
 * 输入：words = ["abcd","dbqca"]
 * 输出：1
 * 解释：字链["abcd"]是最长的字链之一。
 * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
 * <p>
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 * <p>
 * https://leetcode.cn/problems/longest-string-chain/
 */
public class Problem1048_longestStringChain {

    // DP time: O(n^3) space: O(n)
    public static int longestStrChain_dp(String[] words) {
        int len = words.length;

        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

        int max = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            String prevWord = words[i];
            for (int j = i + 1; j < len; j++) {
                String nextWord = words[j];
                if (isPredecessor(prevWord, nextWord)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                }
            }
        }

        return max;
    }

    public static boolean isPredecessor(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 != len2 - 1) {
            return false;
        }

        int p = 0;
        int q = 0;

        while (p < len1 && q < len2) {
            if (word1.charAt(p) == word2.charAt(q)) {
                p++;
            }
            q++;
        }

        return p == len1;
    }

    // HashMap time: O(nC) space: O(n)
    public static int longestStrChain_hashmap(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

        int max = 1;
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            counts.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();
                if (counts.containsKey(next) && counts.get(next) + 1 > counts.get(word)) {
                    counts.put(word, counts.get(next) + 1);
                }
            }

            max = Math.max(max, counts.get(word));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + longestStrChain_dp(new String[]{"a", "b", "ab", "bac"}));
        System.out.println("2 ?= " + longestStrChain_dp(new String[]{"a", "b", "ba", "abc", "abd", "bdca"}));
        System.out.println("4 ?= " + longestStrChain_dp(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println("8 ?= " + longestStrChain_dp(new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"}));

        System.out.println("8 ?= " + longestStrChain_hashmap(new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"}));
    }
}
