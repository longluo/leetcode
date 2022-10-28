package com.longluo.top100;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * <p>
 * https://leetcode.com/problems/group-anagrams/
 */
public class Problem49_groupAnagrams {

    // Count time: O(n^2) space: O(n)
    public static List<List<String>> groupAnagrams_hash(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }

        int len = strs.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> list = new ArrayList<>();
            String word = strs[i];
            list.add(word);
            visited[i] = true;

            for (int j = i + 1; j < len; j++) {
                if (checkAnagram(word, strs[j]) && !visited[j]) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }

            ans.add(list);
        }

        return ans;
    }

    public static boolean checkAnagram(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }

        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for (int i = 0; i < strA.length(); i++) {
            cntA[strA.charAt(i) - 'a']++;
            cntB[strB.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cntA[i] != cntB[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkAnagram_opt(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < strA.length(); i++) {
            count[strA.charAt(i) - 'a']++;
            count[strB.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // Sort time: O(nklogk) space: O(nk)
    public static List<List<String>> groupAnagrams_sort(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] array = s.toCharArray();

            Arrays.sort(array);

            String key = new String(array);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }

        return new ArrayList<>(map.values());
    }

    // Count time: O(n(k + sum)) space: O(n(k+Σ))
    public static List<List<String>> groupAnagrams_count(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] cnt = new int[26];
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(cnt[i]);
                if (i < 25) {
                    sb.append("#");
                }
            }

            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Primes time: O(nk) space: O(nk)
    public static List<List<String>> groupAnagrams_prime(String[] strs) {
        int mod = 1_000_000_007;

        Map<Long, List<String>> map = new HashMap<>();

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        for (String s : strs) {
            long key = 1L;
            for (char ch : s.toCharArray()) {
                key = key * primes[ch - 'a'] % mod;
            }

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + groupAnagrams_hash(new String[]{"", ""}));
        System.out.println("[[tan, nat], [eat, tea, ate], [bat]] ?= " + groupAnagrams_hash(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("[[eat, tea, ate], [bat], [tan, nat]] ?= " + groupAnagrams_sort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("[[tan, nat], [eat, tea, ate], [bat]] ?= " + groupAnagrams_count(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("[[tan, nat], [eat, tea, ate], [bat]] ?= " + groupAnagrams_prime(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("[[aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab], [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]] ?= " + groupAnagrams_prime(new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"}));
    }
}
