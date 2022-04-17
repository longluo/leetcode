package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 819. 最常见的单词
 * <p>
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * 示例：
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * <p>
 * 提示：
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 * <p>
 * https://leetcode-cn.com/problems/most-common-word/
 */
public class Problem819_mostCommonWord {

    // HashMap + HashSet + PQ time: O(n) space: O(n)
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freq = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        int idx = 0;
        int start = 0;
        int len = paragraph.length();
        while (idx < len) {
            while (idx < len && !Character.isLetter(paragraph.charAt(idx))) {
                idx++;
            }

            start = idx;
            while (idx < len && Character.isLetter(paragraph.charAt(idx))) {
                idx++;
            }

            if (idx > start) {
                String word = paragraph.substring(start, idx).toLowerCase();
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }

        while (!pq.isEmpty()) {
            String[] wordFreq = pq.poll();
            if (!bannedSet.contains(wordFreq[0])) {
                return wordFreq[0];
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + mostCommonWord("a.", new String[]{}));
        System.out.println("ball ?= " + mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
