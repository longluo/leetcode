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

    // HashMap + Sort time: O(nlogn) space: O(n)
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        int[][] freqArray = new int[freqMap.size()][2];

        int idx = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            freqArray[idx][0] = (int) ch;
            freqArray[idx][1] = cnt;
            idx++;
        }

        Arrays.sort(freqArray, (o1, o2) -> o2[1] - o1[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freqMap.size(); i++) {
            for (int j = 0; j < freqArray[i][1]; j++) {
                sb.append((char) freqArray[i][0]);
            }
        }

        return sb.toString();
    }

    // PriorityQueue time: O(nlogn) space: O(n)
    // TODO: 2022/9/5  
    public static String frequencySort_pq(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (char ch : s.toCharArray()) {

        }

        StringBuilder sb = new StringBuilder();

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
