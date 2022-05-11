package com.longluo.leetcode.dp;

/**
 * 1641. 统计字典序元音字符串的数目
 * <p>
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * <p>
 * 示例 3：
 * 输入：n = 33
 * 输出：66045
 * <p>
 * 提示：
 * 1 <= n <= 50
 * <p>
 * https://leetcode.cn/problems/count-sorted-vowel-strings/
 */
public class Problem1641_countSortedVowelStrings {

    // Math time: O(1) space: O(1)
    public static int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + countVowelStrings(1));
        System.out.println("15 ?= " + countVowelStrings(2));
        System.out.println("35 ?= " + countVowelStrings(3));
    }
}
