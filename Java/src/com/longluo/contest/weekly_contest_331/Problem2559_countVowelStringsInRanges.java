package com.longluo.contest.weekly_contest_331;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-331
 */

/**
 * 2559. 统计范围内的元音字符串数
 * <p>
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 * <p>
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 * <p>
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 * <p>
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * 示例 1：
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * <p>
 * 示例 2：
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 * <p>
 * 提示：
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 10^5
 * 1 <= queries.length <= 10^5
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 * <p>
 * https://leetcode.cn/problems/count-vowel-strings-in-ranges/
 */
public class Problem2559_countVowelStringsInRanges {

    // BF time: O(mn) space: O(n)
    // TLE
    public static int[] vowelStrings_bf(String[] words, int[][] queries) {
        Set<Character> vowelsSet = new HashSet<>();
        for (char ch : "aeiou".toCharArray()) {
            vowelsSet.add(ch);
        }

        int n = queries.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int cnt = 0;

            for (int j = left; j <= right; j++) {
                String word = words[j];

                if (vowelsSet.contains(word.charAt(0)) && vowelsSet.contains(word.charAt(word.length() - 1))) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    // PrefixSum time: O(n) space: O(n)
    public static int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        for (char ch : "aeiou".toCharArray()) {
            set.add(ch);
        }

        int len = words.length;

        int[] cnt = new int[len];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                cnt[i] = 1;
            }
        }

        int[] prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = cnt[i] + prefixSums[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = prefixSums[right + 1] - prefixSums[left];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3, 0] ?= " + Arrays.toString(vowelStrings_bf(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {
                1, 4}, {1, 1}})));
        System.out.println("[2, 3, 0] ?= " + Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {
                1, 4}, {1, 1}})));
    }
}
