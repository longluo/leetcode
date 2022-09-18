package com.longluo.contest.weekly_contest_311;

import java.util.Arrays;

public class Problem4 {

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

    public static int[] sumPrefixScores_(String[] words) {
        int len = words.length;
        int[] res = new int[len];

//        Trie trie = new Trie();

//        for (String word : words) {
//            trie.insert(word);
//        }

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

    public static int[] sumPrefixScores_trie(String[] words) {
        int len = words.length;
        int[] res = new int[len];

        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        for (int i = 0; i < len; i++) {
            String word = words[i];
            res[i] = word.length();

            int size = word.length();
            for (int j = 1; j <= size; j++) {
                String prefix = word.substring(0, j);
                if (trie.search(prefix)) {
                    res[i]++;
                }
            }
        }

        return res;
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

    public static void main(String[] args) {
        System.out.println("[4] ?= " + Arrays.toString(sumPrefixScores(new String[]{"abcd"})));
        System.out.println("[5, 4, 3, 2] ?= " + Arrays.toString(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));

        System.out.println("[4] ?= " + Arrays.toString(sumPrefixScores_trie(new String[]{"abcd"})));
        System.out.println("[5, 4, 3, 2] ?= " + Arrays.toString(sumPrefixScores_trie(new String[]{"abc", "ab", "bc", "b"})));
    }
}
