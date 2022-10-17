package com.longluo.leetcode.hash;

/**
 * 1832. 判断句子是否为全字母句
 * <p>
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * <p>
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 * <p>
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 */
public class Problem1832_checkIfPangram {

    // Count time: O(n) space: O(C)
    public static boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        for (char ch : sentence.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (int x : cnt) {
            if (x == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println("false ?= " + checkIfPangram("leetcode"));
    }
}
