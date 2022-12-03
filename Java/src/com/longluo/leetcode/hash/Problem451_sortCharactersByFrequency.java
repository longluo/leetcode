package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * https://leetcode.cn/problems/sort-characters-by-frequency/
 */
public class Problem451_sortCharactersByFrequency {

    // HashMap + Sort time: O(n + ClogC) space: O(C)
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        List<int[]> freqList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(freqList, (a, b) -> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for (int[] x : freqList) {
            for (int i = 0; i < x[1]; i++) {
                sb.append((char) x[0]);
            }
        }

        return sb.toString();
    }

    // PriorityQueue time: O(nlogn) space: O(n)
    public static String frequencySort_pq(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));

        for (Character ch : countMap.keySet()) {
            pq.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int i = 0; i < countMap.get(ch); i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("eert ?= " + frequencySort("tree"));
        System.out.println("cccaaa ?= " + frequencySort("cccaaa"));
        System.out.println("bbAa ?= " + frequencySort("Aabb"));

        System.out.println("cccaaa ?= " + frequencySort_pq("cccaaa"));
        System.out.println("bbAa ?= " + frequencySort_pq("Aabb"));
    }
}
