package com.longluo.leetcode.string;

/**
 * 859. 亲密字符串
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；
 * 否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * <p>
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 * 示例 4：
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 10^4
 * s 和 goal 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/buddy-strings/
 */
public class Problem859_buddyStrings {

    // BF time: O(n) space: O(C) = O(26) = O(1)
    public static boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null || s.length() <= 1 || goal.length() <= 1
                || s.length() != goal.length()) {
            return false;
        }

        int len = s.length();
        int first = -1;
        int second = -1;
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < len; i++) {
                int idx = s.charAt(i) - 'a';
                count[idx]++;
                if (count[idx] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (first != second && second >= 0 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + buddyStrings("aa", "aa"));
        System.out.println("false ?= " + buddyStrings("ab", "ab"));
        System.out.println("true ?= " + buddyStrings("ab", "ba"));
        System.out.println("false ?= " + buddyStrings("abac", "abad"));
        System.out.println("true ?= " + buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
