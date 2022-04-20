package com.longluo.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 * <p>
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * 示例 1：
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 示例 2：
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * 提示：
 * 1 <= sentence.length <= 150
 * sentence 由英文字母和空格组成
 * sentence 不含前导或尾随空格
 * sentence 中的所有单词由单个空格分隔
 * <p>
 * https://leetcode-cn.com/problems/goat-latin/
 */
public class Problem824_goatLatin {

    // Simulate Regex time: O(n^2) space: O(n^2)
    public static String toGoatLatin_regex(String sentence) {
        String[] words = sentence.split("\\s+");
        int len = words.length;
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            String word = words[i];
            char ch = word.charAt(0);
            if (vowel.contains(Character.toLowerCase(ch))) {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1, word.length())).append(ch).append("ma");
            }

            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }

            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Simulate time: O(n^2) space: O(n^2)
    public static String toGoatLatin(String sentence) {
        int len = sentence.length();
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        StringBuilder sb = new StringBuilder(len);
        int idx = 0;
        int wordIdx = 1;
        while (idx < len) {
            while (idx < len && sentence.charAt(idx) == ' ') {
                idx++;
            }

            int begin = idx;
            while (idx < len && sentence.charAt(idx) != ' ') {
                idx++;
            }

            String word = sentence.substring(begin, idx);
            char ch = word.charAt(0);
            if (vowels.contains(ch)) {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1, word.length())).append(ch).append("ma");
            }

            for (int j = 0; j < wordIdx; j++) {
                sb.append('a');
            }

            wordIdx++;
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Imaa peaksmaaa oatGmaaaa atinLmaaaaa ?= " + toGoatLatin_regex("I speak Goat Latin"));
        System.out.println("Imaa peaksmaaa oatGmaaaa atinLmaaaaa ?= " + toGoatLatin("I speak Goat Latin"));
    }
}
