package com.longluo.leetcode.twopointers;

/**
 * 392. 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * https://leetcode.cn/problems/is-subsequence/
 */
public class Problem392_isSubsequence {

    // Two Pointers time: O(n) space: O(1)
    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) {
            return false;
        }

        int p = 0;
        int q = 0;
        while (p < sLen && q < tLen) {
            if (s.charAt(p) != t.charAt(q)) {
                q++;
            } else {
                p++;
                q++;
            }
        }

        return p == sLen && q <= tLen;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isSubsequence("abc", "ahbgdc"));
        System.out.println("false ?= " + isSubsequence("axc", "ahbgdc"));
    }
}
