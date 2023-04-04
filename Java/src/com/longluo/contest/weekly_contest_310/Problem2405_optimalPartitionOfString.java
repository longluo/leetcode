package com.longluo.contest.weekly_contest_310;

import java.util.*;


/**
 * 2405. 子字符串的最优划分
 * <p>
 * 给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。
 * 也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
 * <p>
 * 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
 * <p>
 * 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "abacaba"
 * 输出：4
 * 解释：
 * 两种可行的划分方法分别是 ("a","ba","cab","a") 和 ("ab","a","ca","ba") 。
 * 可以证明最少需要划分 4 个子字符串。
 * <p>
 * 示例 2：
 * 输入：s = "ssssss"
 * 输出：6
 * 解释：
 * 只存在一种可行的划分方法 ("s","s","s","s","s","s") 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/optimal-partition-of-string/
 */
public class Problem2405_optimalPartitionOfString {

    // HashSet time: O(n) space: O(26)
    public static int partitionString_hashset(String s) {
        int ans = 0;

        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                ans++;
                set.clear();
            }

            set.add(ch);
        }

        return ans + 1;
    }

    public static int partitionString(String s) {
        int len = s.length();

        int[] count = new int[26];

        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] >= 1) {
                Arrays.fill(count, 0);
                count[ch - 'a']++;
                ans++;
            } else {
                count[ch - 'a']++;
            }
        }

        return ans + 1;
    }

    public static int partitionString_map(String s) {
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.getOrDefault(ch, 0) >= 1) {
                map.clear();
                ans++;
            }

            map.put(ch, 1);
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + partitionString("abacaba"));
        System.out.println("6 ?= " + partitionString("ssssss"));
        System.out.println("4 ?= " + partitionString("hdklqkcssgxlvehva"));
        System.out.println("4 ?= " + partitionString_map("hdklqkcssgxlvehva"));

        System.out.println("4 ?= " + partitionString_hashset("hdklqkcssgxlvehva"));
    }
}
