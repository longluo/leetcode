package com.longluo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 844. 比较含退格的字符串
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * https://leetcode.cn/problems/backspace-string-compare/
 */
public class Problem844_backspaceStringCompare {

    // StringBuilder time: O(n) space: O(n)
    // TLE
    public static boolean backspaceCompare_sb(String s, String t) {
        int sLen = s.length();
        StringBuilder src = new StringBuilder(sLen);
        int idx = 0;
        while (idx < sLen) {
            if (s.charAt(idx) != '#') {
                src.append(s.charAt(idx++));
            } else {
                if (src.length() > 0) {
                    while (src.length() > 0 && idx < sLen && s.charAt(idx) == '#') {
                        src.deleteCharAt(src.length() - 1);
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        }

        idx = 0;
        int tLen = t.length();
        StringBuilder dest = new StringBuilder(tLen);
        while (idx < tLen) {
            if (t.charAt(idx) != '#') {
                dest.append(t.charAt(idx++));
            } else {
                if (idx > 0) {
                    while (dest.length() > 0 && idx < tLen && t.charAt(idx) == '#') {
                        dest.deleteCharAt(dest.length() - 1);
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        }

        return src.toString().equals(dest.toString());
    }

    // Stack time: O(n) space: O(n)
    public static boolean backspaceCompare_stack(String s, String t) {
        Deque<Character> srcStk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                srcStk.push(s.charAt(i));
            } else if (s.charAt(i) == '#' && !srcStk.isEmpty()) {
                srcStk.pop();
            }
        }

        Deque<Character> destStk = new ArrayDeque<>();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                destStk.push(t.charAt(i));
            } else if (t.charAt(i) == '#' && !destStk.isEmpty()) {
                destStk.pop();
            }
        }

        return srcStk.toString().equals(destStk.toString());
    }

    // Two Pointers time: O(m+n) space: O(1)
    public static boolean backspaceCompare_tp(String s, String t) {
        int p = s.length() - 1;
        int q = t.length() - 1;
        int skipSrc = 0;
        int skipDest = 0;

        while (p >= 0 || q >= 0) {
            while (p >= 0) {
                if (s.charAt(p) == '#') {
                    p--;
                    skipSrc++;
                } else if (skipSrc > 0) {
                    p--;
                    skipSrc--;
                } else {
                    break;
                }
            }

            while (q >= 0) {
                if (t.charAt(q) == '#') {
                    q--;
                    skipDest++;
                } else if (skipDest > 0) {
                    q--;
                    skipDest--;
                } else {
                    break;
                }
            }

            if (p >= 0 && q >= 0 && s.charAt(p) != t.charAt(q)) {
                return false;
            } else if (p >= 0 && q >= 0 && s.charAt(p) == t.charAt(q)) {
                p--;
                q--;
            } else if ((p >= 0 && q < 0) || (p < 0 && q >= 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + backspaceCompare_sb("ab#c", "ad#c"));

        System.out.println("true ?= " + backspaceCompare_stack("a##c", "#a#c"));

        System.out.println("true ?= " + backspaceCompare_tp("a##c", "#a#c"));
        System.out.println("false ?= " + backspaceCompare_tp("bxj##tw", "bxj###tw"));
        System.out.println("true ?= " + backspaceCompare_tp("ab##", "c#d#"));
    }
}
