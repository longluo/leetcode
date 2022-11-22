package com.longluo.leetcode.trie;

import java.util.*;

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

    // Binary Search time: O() space: O(n)
    public static int numMatchingSubseq_bs(String s, String[] words) {
        int len = s.length();

        List<Integer>[] marks = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            marks[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            marks[idx].add(i);
        }

        int ans = words.length;
        for (String word : words) {
            int p = -1;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = binarySearch(marks[ch - 'a'], p);
                if (idx <= p) {
                    ans--;
                    break;
                }

                p = idx;
            }
        }

        return ans;
    }

    private static int binarySearch(List<Integer> list, int target) {
        if (list.size() == 0) {
            return -1;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return list.get(left) > target ? list.get(left) : -1;
    }

    // Count time: O(len + sum(len)) space: O(words.len)
    // TODO: 2022/11/17  
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

    // Trie time: O(mn) space: O(n)
    // AC
    public static int numMatchingSubseq_trie(String s, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        return trie.search(s);
    }

    static class Trie {
        int cnt = 0;
        Trie[] children;

        Trie() {
            cnt = 0;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie curNode = this;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curNode.children[idx] == null) {
                    curNode.children[idx] = new Trie();
                }

                curNode = curNode.children[idx];
            }

            curNode.cnt++;
        }

        int result;

        public int search(String word) {
            search(word, 0, this);
            return result;
        }

        /**
         * 深度优先遍历
         * <p>
         * cnt 变量存储树中以此结点为结尾的单词的数量
         * <p>
         * 首先构建字典树，然后深度优先遍历字典树，当前结点如果 cnt > 0 ，将 cnt 的数量加入 result 中遍历当前结点的后续结点，
         * <p>
         * 不为空时，判断后续结点的字符是否存在与字符串中如果存在则递归
         * <p>
         * 这里递归时传入的判断字符是否存在时的起始点
         * 也就是下一个字符必须出现在当前字符的后面才符合条件
         * <p>
         *
         * @param word
         * @param index
         * @param node
         */
        public void search(String word, int index, Trie node) {
            if (node.cnt > 0) {
                result += node.cnt;
            }

            for (int i = 0; i < node.children.length; i++) {
                Trie next = node.children[i];

                if (next != null) {
                    int indexOf = word.indexOf(i + 'a', index);
                    if (indexOf != -1) {
                        search(word, indexOf + 1, next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numMatchingSubseq_bf("abcde", new String[]{"a", "bb", "acd", "ace"}));

        System.out.println("2 ?= " + numMatchingSubseq_bs("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
        System.out.println("3 ?= " + numMatchingSubseq_bs("abcde", new String[]{"a", "bb", "acd", "ace"}));

        System.out.println("3 ?= " + numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));

        System.out.println("3 ?= " + numMatchingSubseq_trie("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
