package com.longluo.studyplan.ke;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 * <p>
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 */
public class Problem30_substringWithConcatenationOfAllWords {

    // Simulate + HashMap time: O(n*m) space: O(m)
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> allWordsMap = new HashMap<>();
        for (String word : words) {
            allWordsMap.put(word, allWordsMap.getOrDefault(word, 0) + 1);
        }

        int len = s.length();
        int wordsCnt = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < len - wordsCnt * wordLen + 1; i++) {
            Map<String, Integer> hasWordsMap = new HashMap<>();
            int hasWordsCnt = 0;
            while (hasWordsCnt < wordsCnt) {
                String word = s.substring(i + hasWordsCnt * wordLen, i + (hasWordsCnt + 1) * wordLen);
                if (allWordsMap.containsKey(word)) {
                    hasWordsMap.put(word, hasWordsMap.getOrDefault(word, 0) + 1);
                    if (hasWordsMap.get(word) > allWordsMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }

                hasWordsCnt++;
            }

            if (hasWordsCnt == wordsCnt) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0, 9] ?= " + findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
