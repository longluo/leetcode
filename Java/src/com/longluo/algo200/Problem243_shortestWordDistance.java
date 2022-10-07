package com.longluo.algo200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 243. 最短单词距离
 * <p>
 * 给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
 * <p>
 * 示例 1:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出: 1
 * <p>
 * 提示:
 * 1 <= wordsDict.length <= 3 * 10^4
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] 由小写英文字母组成
 * word1 和 word2 在 wordsDict 中
 * word1 != word2
 * <p>
 * https://leetcode.cn/problems/shortest-word-distance/
 */
public class Problem243_shortestWordDistance {

    // HashMap time: O(n) space: O(n)
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }

        int ans = len;
        List<Integer> word1Idx = map.get(word1);
        List<Integer> word2Idx = map.get(word2);

        for (int i = 0; i < word1Idx.size(); i++) {
            for (int j = 0; j < word2Idx.size(); j++) {
                ans = Math.min(ans, Math.abs(word1Idx.get(i) - word2Idx.get(j)));
            }
        }

        return ans;
    }

    // Opt time: O(n) space: O(2)
    public static int shortestDistance_opt(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;

        Map<String, Integer> map = new HashMap<>();

        int ans = len;
        for (int i = 0; i < len; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                if (map.containsKey(word2)) {
                    int idx = map.get(word2);
                    ans = Math.min(ans, i - idx);
                }

                map.put(word1, i);
            } else if (word.equals(word2)) {
                if (map.containsKey(word1)) {
                    int idx = map.get(word1);
                    ans = Math.min(ans, i - idx);
                }

                map.put(word2, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        System.out.println("3 ?= " + shortestDistance_opt(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        System.out.println("1 ?= " + shortestDistance_opt(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
    }
}
