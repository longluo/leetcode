package com.longluo.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * <p>
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * 示例：
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * 提示：
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * <p>
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class Problem890_findAndReplacePattern {

    // HashMap time: O(mn) space: O(n)
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int len = pattern.length();

        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }

            boolean flag = true;
            Map<Character, Character> wordMap = new HashMap<>();
            Map<Character, Character> patMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (wordMap.containsKey(word.charAt(i)) || patMap.containsKey(pattern.charAt(i))) {
                    if ((wordMap.containsKey(word.charAt(i)) && wordMap.get(word.charAt(i)) != pattern.charAt(i))
                            || (patMap.containsKey(pattern.charAt(i)) && patMap.get(pattern.charAt(i)) != word.charAt(i))) {
                        flag = false;
                        break;
                    }
                } else {
                    wordMap.put(word.charAt(i), pattern.charAt(i));
                    patMap.put(pattern.charAt(i), word.charAt(i));
                }
            }

            if (flag) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[mee, aqq] ?= " + findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
