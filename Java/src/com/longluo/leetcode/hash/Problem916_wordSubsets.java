package com.longluo.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. 单词子集
 * <p>
 * 给你两个字符串数组 words1 和 words2。
 * <p>
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称字符串 b 是字符串 a 的 子集 。
 * <p>
 * 例如，"wrr" 是 "warrior" 的子集，但不是 "world" 的子集。
 * 如果对 words2 中的每一个单词 b，b 都是 a 的子集，那么我们称 words1 中的单词 a 是 通用单词 。
 * <p>
 * 以数组形式返回 words1 中所有的通用单词。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 * <p>
 * 示例 2：
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
 * 输出：["apple","google","leetcode"]
 * <p>
 * 示例 3：
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","oo"]
 * 输出：["facebook","google"]
 * <p>
 * 示例 4：
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lo","eo"]
 * 输出：["google","leetcode"]
 * <p>
 * 示例 5：
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["ec","oc","ceo"]
 * 输出：["facebook","leetcode"]
 * <p>
 * 提示：
 * 1 <= words1.length, words2.length <= 10^4
 * 1 <= words1[i].length, words2[i].length <= 10
 * words1[i] 和 words2[i] 仅由小写英文字母组成
 * words1 中的所有字符串 互不相同
 * <p>
 * https://leetcode.cn/problems/word-subsets/
 */
public class Problem916_wordSubsets {

    // BF time: O(n^2*mn) space: O(26)
    // TLE
    public static List<String> wordSubsets_bf(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        for (String word : words1) {
            boolean flag = true;
            for (int i = 0; i < words2.length; i++) {
                if (!checkSubset(word, words2[i])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(word);
            }
        }

        return ans;
    }

    private static boolean checkSubset(String a, String b) {
        int[] count = new int[26];

        for (char ch : a.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : b.toCharArray()) {
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[facebook, google, leetcode] ?= " + wordSubsets_bf(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
    }
}
