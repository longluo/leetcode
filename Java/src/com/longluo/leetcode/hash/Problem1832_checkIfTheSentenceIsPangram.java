package com.longluo.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

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
public class Problem1832_checkIfTheSentenceIsPangram {

    // HashSet time: O(n) space: O(C)
    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }

        return set.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + checkIfPangram("leetcode"));
        System.out.println("false ?= " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
