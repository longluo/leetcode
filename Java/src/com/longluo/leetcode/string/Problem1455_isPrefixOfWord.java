package com.longluo.leetcode.string;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * <p>
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * <p>
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 * <p>
 * 示例 1：
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 * <p>
 * 示例 2：
 * 输入：sentence = "this problem is an easy problem", searchWord = "pro"
 * 输出：2
 * 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
 * <p>
 * 示例 3：
 * 输入：sentence = "i am tired", searchWord = "you"
 * 输出：-1
 * 解释："you" 不是句子中任何单词的前缀。
 * <p>
 * 提示：
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * <p>
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class Problem1455_isPrefixOfWord {

    // Regex
    public static int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.startsWith(searchWord)) {
                ans = i + 1;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + isPrefixOfWord("i love eating burger", "burg"));
    }
}
