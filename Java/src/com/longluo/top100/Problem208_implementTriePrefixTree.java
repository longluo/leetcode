package com.longluo.top100;

/**
 * 208. 实现 Trie (前缀树)
 * <p>
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word和prefix仅由小写英文字母组成
 * insert、search和startsWith调用次数总计不超过3 * 10^4次
 * <p>
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Problem208_implementTriePrefixTree {

    // Trie time: O(S) space: O(26*n)
    static class Trie_node {

        static class TrieNode {
            boolean isEnd;
            TrieNode next[];

            public TrieNode() {
                isEnd = false;
                next = new TrieNode[26];
            }
        }


        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        // O(1)
        public Trie_node() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new TrieNode();
                }

                node = node.next[ch - 'a'];
            }

            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.next[ch - 'a'];
                if (node == null) {
                    return false;
                }
            }

            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    return false;
                }

                node = node.next[ch - 'a'];
            }

            return true;
        }
    }

    // Trie
    static class Trie {
        boolean isEnd;
        Trie next[];

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

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie node = this;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    return null;
                }

                node = node.next[idx];
            }

            return node;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie tst1 = new Trie();
        tst1.insert("apple");
        tst1.insert("apple");
        tst1.search("apple");   // 返回 True
        tst1.search("app");     // 返回 False
        tst1.startsWith("app"); // 返回 True
        tst1.insert("app");
        tst1.search("app");
    }
}
