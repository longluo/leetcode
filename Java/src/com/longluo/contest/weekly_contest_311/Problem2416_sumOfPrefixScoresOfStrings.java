package com.longluo.contest.weekly_contest_311;

import java.util.Arrays;

/**
 * 2416. 字符串的前缀分数和
 * <p>
 * 给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。
 * <p>
 * 定义字符串 word 的 分数 等于以 word 作为 前缀 的 words[i] 的数目。
 * <p>
 * 例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 "abc" 的一个前缀。
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。
 * <p>
 * 注意：字符串视作它自身的一个前缀。
 * <p>
 * 示例 1：
 * 输入：words = ["abc","ab","bc","b"]
 * 输出：[5,4,3,2]
 * 解释：对应每个字符串的答案如下：
 * - "abc" 有 3 个前缀："a"、"ab" 和 "abc" 。
 * - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" ，1 个字符串的前缀为 "abc" 。
 * 总计 answer[0] = 2 + 2 + 1 = 5 。
 * - "ab" 有 2 个前缀："a" 和 "ab" 。
 * - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" 。
 * 总计 answer[1] = 2 + 2 = 4 。
 * - "bc" 有 2 个前缀："b" 和 "bc" 。
 * - 2 个字符串的前缀为 "b" ，1 个字符串的前缀为 "bc" 。
 * 总计 answer[2] = 2 + 1 = 3 。
 * - "b" 有 1 个前缀："b"。
 * - 2 个字符串的前缀为 "b" 。
 * 总计 answer[3] = 2 。
 * <p>
 * 示例 2：
 * 输入：words = ["abcd"]
 * 输出：[4]
 * 解释：
 * "abcd" 有 4 个前缀 "a"、"ab"、"abc" 和 "abcd"。
 * 每个前缀的分数都是 1 ，总计 answer[0] = 1 + 1 + 1 + 1 = 4 。
 * <p>
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/sum-of-prefix-scores-of-strings/
 */
public class Problem2416_sumOfPrefixScoresOfStrings {

    // BF time: O(n^3) space: O(n)
    // TLE
    public static int[] sumPrefixScores(String[] words) {
        int len = words.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            int size = word.length();
            int cnt = 0;

            for (int j = 1; j <= size; j++) {
                String prefix = word.substring(0, j);
                for (int k = 0; k < len; k++) {
                    if (words[k].startsWith(prefix)) {
                        cnt++;
                    }
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    // Opt time: O(n^3) space: O(n)
    // TLE
    public static int[] sumPrefixScores_opt(String[] words) {
        int len = words.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            int cnt = word.length();
            for (int j = 1; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                for (int k = 0; k < len; k++) {
                    if (i != k && words[k].startsWith(prefix)) {
                        cnt++;
                    }
                }
            }

            res[i] = cnt;
        }

        return res;
    }

    // Trie time: O(L) space: O(n)
    public static int[] sumPrefixScores_trie(String[] words) {
        int len = words.length;
        int[] res = new int[len];

        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        for (int i = 0; i < len; i++) {
            res[i] = trie.query(words[i]);
        }

        return res;
    }

    // Trie
    static class Trie {
        int value;
        Trie next[];

        public Trie() {
            value = 0;
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Trie();
                }

                node.next[idx].value++;
                node = node.next[idx];
            }
        }

        public int query(String prefix) {
            Trie node = this;
            int cnt = 0;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';

                if (node.next[idx] == null) {
                    break;
                }

                cnt += node.next[idx].value;
                node = node.next[idx];
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println("[4] ?= " + Arrays.toString(sumPrefixScores(new String[]{"abcd"})));
        System.out.println("[5, 4, 3, 2] ?= " + Arrays.toString(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));

        System.out.println("[5, 4, 3, 2] ?= " + Arrays.toString(sumPrefixScores_opt(new String[]{"abc", "ab", "bc", "b"})));

        System.out.println("[4] ?= " + Arrays.toString(sumPrefixScores_trie(new String[]{"abcd"})));
        System.out.println("[5, 4, 3, 2] ?= " + Arrays.toString(sumPrefixScores_trie(new String[]{"abc", "ab", "bc", "b"})));
    }
}
