package com.longluo.leetcode.priorityqueue;

import java.util.*;

/**
 * 692. 前K个高频单词
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * 注意：
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 * <p>
 * 扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * <p>
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Problem692_topKFrequentWords {

    // HashMap + Sort time: O(nlogn) space: O(n)
    public static List<String> topKFrequent_hashmap(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return ans;
        }

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(freqMap.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }

            return o2.getValue() - o1.getValue();
        });

        for (Map.Entry<String, Integer> entry : list) {
            ans.add(entry.getKey());
            k--;
            if (k <= 0) {
                return ans;
            }
        }

        return ans;
    }

    // HashMap time: O(ln+lmlogm) space: O(lm)
    public static List<String> topKFrequent_hashmap_opt(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        ans.addAll(freqMap.keySet());

        Collections.sort(ans, (o1, o2) -> {
            if (freqMap.get(o1) == freqMap.get(o2)) {
                return o1.compareTo(o2);
            }

            return freqMap.get(o2) - freqMap.get(o1);
        });

        return ans.subList(0, k);
    }

    // PriorityQueue time: O(nlogn) space: O(n)
    public static List<String> topKFrequent_pq(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>((word1, word2) -> {
            if (countMap.get(word1) == countMap.get(word2)) {
                return word2.compareTo(word1);
            }
            return countMap.get(word1) - countMap.get(word2);
        });

        for (String word : countMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[i, love] ?= " + topKFrequent_hashmap(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("[the, is, sunny, day] ?= " + topKFrequent_hashmap(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

        System.out.println("[the, is, sunny, day] ?= " + topKFrequent_hashmap_opt(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

        System.out.println("[i, love] ?= " + topKFrequent_pq(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("[the, is, sunny, day] ?= " + topKFrequent_pq(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
