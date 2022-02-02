package com.longluo.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词
 * <p>
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * <p>
 * 示例 1：
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * <p>
 * 示例 2：
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 200
 * s1 和 s2 由小写英文字母和空格组成
 * s1 和 s2 都不含前导或尾随空格
 * s1 和 s2 中的所有单词间均由单个空格分隔
 * <p>
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
public class Problem884_uncommonFromSentences {

    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> s1freq = new HashMap<>();
        Map<String, Integer> s2freq = new HashMap<>();
        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");
        for (String word : words1) {
            s1freq.put(word, s1freq.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            s2freq.put(word, s2freq.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String word : s1freq.keySet()) {
            if (s1freq.get(word) == 1 && !s2freq.containsKey(word)) {
                ans.add(word);
            }
        }
        for (String word : s2freq.keySet()) {
            if (s2freq.get(word) == 1 && !s1freq.containsKey(word)) {
                ans.add(word);
            }
        }

        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
