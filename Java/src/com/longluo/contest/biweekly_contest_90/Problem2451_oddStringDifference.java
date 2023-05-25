package com.longluo.contest.biweekly_contest_90;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-90/
 */

/**
 * 2451. 差值数组不同的字符串
 * <p>
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，
 * 其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。
 * 注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * <p>
 * 示例 2：
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * 提示：
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 * <p>
 * https://leetcode.cn/problems/odd-string-difference/
 */
public class Problem2451_oddStringDifference {

    // HashMap time: O(nk) space: O(n)
    public static String oddString(String[] words) {
        int len = words.length;

        int n = words[0].length();

        int ans = -1;

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, int[]> map = new HashMap<>();

            for (int j = 0; j < len; j++) {
                String word = words[j];
                int diff = word.charAt(i + 1) - word.charAt(i);
                map.putIfAbsent(diff, new int[]{0, -1});
                int[] x = map.get(diff);
                x[0]++;
                x[1] = j;
                map.put(diff, x);
            }

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] value = entry.getValue();
                if (value[0] == 1) {
                    ans = value[1];
                    return words[ans];
                }
            }
        }

        return words[ans];
    }

    // BF time: O(mn) space: O(mn)
    public static String oddString_bf(String[] words) {
        int len = words.length;

        int n = words[0].length();

        int[][] diffArr = new int[len][n - 1];

        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j < n - 1; j++) {
                diffArr[i][j] = s.charAt(j + 1) - s.charAt(j);
            }
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String s = Arrays.toString(diffArr[i]);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            String s = Arrays.toString(diffArr[i]);
            if (map.get(s) == 1) {
                return words[i];
            }
        }

        return words[0];
    }

    public static void main(String[] args) {
        System.out.println("abc ?= " + oddString(new String[]{"adc", "wzy", "abc"}));
        System.out.println("abc ?= " + oddString_bf(new String[]{"adc", "wzy", "abc"}));
        System.out.println("bob ?= " + oddString_bf(new String[]{"aaa", "bob", "ccc", "ddd"}));
        System.out.println("ddd ?= " + oddString_bf(new String[]{"ddd", "poo", "baa", "onn"}));
    }
}
