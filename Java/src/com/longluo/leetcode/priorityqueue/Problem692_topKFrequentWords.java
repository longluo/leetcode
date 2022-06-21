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
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * 扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * <p>
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Problem692_topKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return res;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (wordMap.containsKey(words[i])) {
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            } else {
                wordMap.put(words[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        for (Map.Entry<String, Integer> entry : list) {
            res.add(entry.getKey());
            k--;
            if (k <= 0) {
                return res;
            }
        }

        return res;
    }

    public static List<String> topKFrequent_2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cnt.put(words[i], cnt.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[i, love] ?= " + topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("[i, love] ?= " + topKFrequent_2(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("[the, is, sunny, day] ?= " + topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println("[the, is, sunny, day] ?= " + topKFrequent_2(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
