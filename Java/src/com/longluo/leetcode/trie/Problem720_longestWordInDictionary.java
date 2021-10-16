package com.longluo.leetcode.trie;

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

        return "";
    }

    public static void main(String[] args) {
        System.out.println("world ?= " + longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println("apple ?= " + longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
