package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class Problem1047_removeAllAdjacentDuplicatesInString {

    // BF time: O(n) space: O(n)
    public static String removeDuplicates_bf(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    // Stack time: O(n) space: O(n)
    public static String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            if (!st.empty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        if (st.empty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.capacity(); i++) {
            if (!st.empty()) {
                sb.append(st.pop());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("ca ?= " + removeDuplicates_bf("abbaca"));
        System.out.println("c ?= " + removeDuplicates_bf("c"));
        System.out.println(" ?= " + removeDuplicates_bf("aa"));
        System.out.println("ab ?= " + removeDuplicates_bf("ab"));

        System.out.println("ca ?= " + removeDuplicates("abbaca"));
        System.out.println("c ?= " + removeDuplicates("c"));
        System.out.println(" ?= " + removeDuplicates("aa"));
        System.out.println("ab ?= " + removeDuplicates("ab"));
    }
}
