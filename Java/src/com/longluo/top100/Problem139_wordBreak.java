package com.longluo.top100;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 提示：
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * <p>
 * https://leetcode-cn.com/problems/word-break/
 */
public class Problem139_wordBreak {

    // DP time: O(n^2) space: O(n)
    public static boolean wordBreak_dp(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                dp[word.length()] = true;
            }
        }

        for (int i = 0; i < len; i++) {
            if (dp[i]) {
                for (String word : wordDict) {
                    if (s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
        }

        return dp[len];
    }

    // Trie Done
    public static boolean wordBreak_trie(String s, List<String> wordDict) {
        Trie root = new Trie();
        for (String word : wordDict) {
            root.insert(word);
        }

        return root.search(s, 0);
    }

    static class Trie {
        public boolean isEnd;
        public Trie next[];

        boolean[] failed = new boolean[301];

        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Trie();
                }

                node = node.next[idx];
            }

            node.isEnd = true;
        }

        public boolean search(String s, int start) {
            if (failed[start]) {
                return false;
            }

            if (start >= s.length()) {
                return true;
            }

            Trie root = this;
            Trie pNode = root;
            int len = s.length();
            for (int i = start; i < len; i++) {
                int idx = s.charAt(i) - 'a';
                if (pNode.next[idx] == null) {
                    return false;
                }

                pNode = pNode.next[idx];
                if (pNode.isEnd) {
                    if (search(s, i + 1)) {
                        return true;
                    }

                    failed[i + 1] = true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + wordBreak_dp("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println("true ?= " + wordBreak_dp("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));
        System.out.println("false ?= " + wordBreak_dp("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));

        System.out.println("false ?= " + wordBreak_trie("aaaa", Arrays.asList(new String[]{"aaa"})));
        System.out.println("true ?= " + wordBreak_trie("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println("false ?= " + wordBreak_trie("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }
}
