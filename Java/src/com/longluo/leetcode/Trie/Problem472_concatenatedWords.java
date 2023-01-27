package com.longluo.leetcode.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 472. 连接词
 * <p>
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * <p>
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * <p>
 * 示例 2：
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 * <p>
 * 提示：
 * 1 <= words.length <= 10^4
 * 0 <= words[i].length <= 30
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 10^5
 * <p>
 * https://leetcode.cn/problems/concatenated-words/
 */
public class Problem472_concatenatedWords {

    // TODO: 2023/1/27  
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();


        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[catdog] ?= " + findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}));
        System.out.println("[catsdogcats, dogcatsdog, ratcatdogcat] ?= " + findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }
}
