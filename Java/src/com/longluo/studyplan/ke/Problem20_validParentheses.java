package com.longluo.studyplan.ke;

import java.util.*;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Problem20_validParentheses {

    // Stack time: O(n) space: O(n)
    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else if (ch == ')' && !stk.empty() && stk.peek() == '(') {
                stk.pop();
            } else if (ch == ']' && !stk.empty() && stk.peek() == '[') {
                stk.pop();
            } else if (ch == '}' && !stk.empty() && stk.peek() == '{') {
                stk.pop();
            } else {
                return false;
            }
        }

        if (!stk.empty()) {
            return false;
        }

        return true;
    }

    // HashMap time: O(n) space: O(n)
    public static boolean isValid_map(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isValid("()"));
        System.out.println("true ?= " + isValid("()[]{}"));
        System.out.println("false ?= " + isValid("(]"));
        System.out.println("false ?= " + isValid("([}}])"));
        System.out.println("false ?= " + isValid_map("([}}])"));
    }
}
