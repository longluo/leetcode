package com.longluo.contest.weekly_contest_309;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-309/
 */

/**
 * 2399. 检查相同字母间的距离
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次 。
 * 另给你一个下标从 0 开始、长度为 26 的的整数数组 distance 。
 * <p>
 * 字母表中的每个字母按从 0 到 25 依次编号（即，'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25）。
 * <p>
 * 在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i] 。如果第 i 个字母没有在 s 中出现，
 * 那么 distance[i] 可以 忽略 。
 * <p>
 * 如果 s 是一个 匀整 字符串，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：true
 * 解释：
 * - 'a' 在下标 0 和下标 2 处出现，所以满足 distance[0] = 1 。
 * - 'b' 在下标 1 和下标 5 处出现，所以满足 distance[1] = 3 。
 * - 'c' 在下标 3 和下标 4 处出现，所以满足 distance[2] = 0 。
 * 注意 distance[3] = 5 ，但是由于 'd' 没有在 s 中出现，可以忽略。
 * 因为 s 是一个匀整字符串，返回 true 。
 * <p>
 * 示例 2：
 * 输入：s = "aa", distance = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：false
 * 解释：
 * - 'a' 在下标 0 和 1 处出现，所以两次出现之间的字母数量为 0 。
 * 但是 distance[0] = 1 ，s 不是一个匀整字符串。
 * <p>
 * 提示：
 * 2 <= s.length <= 52
 * s 仅由小写英文字母组成
 * s 中的每个字母恰好出现两次
 * distance.length == 26
 * 0 <= distance[i] <= 50
 * <p>
 * https://leetcode.cn/problems/check-distances-between-same-letters/
 */
public class Problem2399_checkDistancesBetweenSameLetter {

    //
    public static boolean checkDistances(String s, int[] distance) {
        int len = s.length();

        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int[] pos = map.get(ch);
                pos[1] = i;
                map.put(ch, pos);
            } else {
                map.put(ch, new int[]{i, -1});
            }
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            char ch = entry.getKey();
            int[] pos = entry.getValue();
            int dist = pos[1] - pos[0] - 1;
            if (dist != distance[ch - 'a']) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkDistances_opt(String s, int[] distance) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int last = map.get(ch);
                if (i - last != distance[ch - 'a']) {
                    return false;
                }
            } else {
                map.put(ch, i);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println("false ?= " + checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println("false ?= " + checkDistances_opt("abaccb",
                new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
