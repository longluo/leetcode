package com.longluo.leetcode.trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 * <p>
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * <p>
 * 示例 1：
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * <p>
 * 示例 2：
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * 提示：
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 * <p>
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */
public class Problem720_longestWordInDictionary {

    public static String longestWord(String[] words) {
        if (words == null) {
            return "";
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                }

                return o1.length() - o2.length();
            }
        });

        int len = words.length;
        Set<String> res = new HashSet<>();
        String ans = "";
        res.add("");
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (res.contains(word.substring(0, word.length() - 1))) {
                res.add(word);
                ans = word;
            }
        }

        return ans;
    }

    class Trie {
        int len;
        char[] array;

        Trie(int len, char ch) {
            this.len = len;

        }
    }

    public static void main(String[] args) {
        System.out.println("world ?= " + longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println("apple ?= " + longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
