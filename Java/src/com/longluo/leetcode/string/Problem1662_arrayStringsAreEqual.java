package com.longluo.leetcode.string;

/**
 * 1662. 检查两个字符串数组是否相等
 * <p>
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * 示例 1：
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * <p>
 * 示例 2：
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= word1.length, word2.length <= 10^3
 * 1 <= word1[i].length, word2[i].length <= 10^3
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 * word1[i] 和 word2[i] 由小写字母组成
 * <p>
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 */
public class Problem1662_arrayStringsAreEqual {

    // Simulate time: O(n) space: O(n)
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (String x : word1) {
            s1.append(x);
        }

        for (String x : word2) {
            s2.append(x);
        }

        return s1.compareTo(s2) == 0;
    }

    // Simulate time: O(n) space: O(1)
    public static boolean arrayStringsAreEqual_opt(String[] word1, String[] word2) {
        int p = 0;
        int q = 0;

        int i = 0;
        int j = 0;

        while (p < word1.length || q < word2.length) {
            if ((p < word1.length && q == word2.length) || (p == word1.length && q < word2.length)) {
                return false;
            }

            if (word1[p].charAt(i) != word2[q].charAt(j)) {
                return false;
            }

            i++;
            j++;

            if (i == word1[p].length()) {
                p++;
                i = 0;
            }

            if (j == word2[q].length()) {
                q++;
                j = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println("true ?= " + arrayStringsAreEqual_opt(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println("false ?= " + arrayStringsAreEqual_opt(new String[]{"abc", "d", "defg"}, new String[]{"abcddef"}));
    }
}
