package com.longluo.algo200;

/**
 * 1119. 删去字符串中的元音
 * <p>
 * 给你一个字符串 s ，请你删去其中的所有元音字母 'a'，'e'，'i'，'o'，'u'，并返回这个新字符串。
 * <p>
 * 示例 1：
 * 输入：s = "leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * <p>
 * 示例 2：
 * 输入：s = "aeiou"
 * 输出：""
 * <p>
 * 提示：
 * 1 <= S.length <= 1000
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/remove-vowels-from-a-string/
 */
public class Problem1119_removeVowelsFromAString {

    // Simulate time: O(n) space: O(n)
    public static String removeVowels(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }

            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("ltcdscmmntyfrcdrs ?= " + removeVowels("leetcodeisacommunityforcoders"));
    }
}
