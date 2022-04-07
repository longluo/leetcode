package com.longluo.leetcode.string;

/**
 * 796. 旋转字符串
 * <p>
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/rotate-string/
 */
public class Problem796_rotateString {

    // BF substring time: O(n) space: O(n)
    public static boolean rotateString_bf(String A, String B) {
        if (A.equals(B)) {
            return true;
        }

        if (A.length() != B.length()) {
            return false;
        }

        int len = A.length();
        for (int i = 1; i < len; i++) {
            String str = A.substring(i, len) + A.substring(0, i);
            if (str.equals(B)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + rotateString_bf("abcde", "cdeab"));
        System.out.println("true ?= " + rotateString_bf("bbbacddceeb", "ceebbbbacdd"));
    }
}
