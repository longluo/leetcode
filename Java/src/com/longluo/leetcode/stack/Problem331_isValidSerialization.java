package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * <p>
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * <p>
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class Problem331_isValidSerialization {

    public static boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        int n = preorder.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int idx = 0;
        while (idx < n) {
            if (stack.empty()) {
                return false;
            }

            if (preorder.charAt(idx) == ',') {
                idx++;
            } else if (preorder.charAt(idx) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                idx++;
            } else {
                while (idx < n && preorder.charAt(idx) != ',') {
                    idx++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println("false ?= " + isValidSerialization("1,#"));
        System.out.println("false ?= " + isValidSerialization("9,#,#,1"));
    }
}
