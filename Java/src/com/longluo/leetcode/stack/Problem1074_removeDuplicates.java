package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
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
 */
public class Problem1074_removeDuplicates {

    public static String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }

        int n = S.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder(n);

        for (int i = n - 1; i >= 0; i--) {
            if (!st.empty() && st.peek() == S.charAt(i)) {
                st.pop();
            } else {
                st.push(S.charAt(i));
            }
        }

        if (st.empty()) {
            return "";
        }

        for (int i = 0; i < st.capacity(); i++) {
            if (!st.empty()) {
                sb.append(st.pop());
            }
        }

        return sb.toString();
    }

    public static String removeDuplicates_2(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }

        int n = S.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == S.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("ca ?= " + removeDuplicates("abbaca"));
        System.out.println("c ?= " + removeDuplicates("c"));
        System.out.println(" ?= " + removeDuplicates("aa"));
        System.out.println("ab ?= " + removeDuplicates("ab"));

        System.out.println("ca ?= " + removeDuplicates_2("abbaca"));
        System.out.println("c ?= " + removeDuplicates_2("c"));
        System.out.println(" ?= " + removeDuplicates_2("aa"));
        System.out.println("ab ?= " + removeDuplicates_2("ab"));
    }
}
