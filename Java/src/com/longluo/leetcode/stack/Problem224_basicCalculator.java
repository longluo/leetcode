package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 224. 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class Problem224_basicCalculator {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();
        Stack<Integer> numSt = new Stack<>();
        int n = s.length();
        int num = 0;
        char preSign = '+';

        for (int i = 0; i < n; i++) {

        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println("2 ?= " + calculate("1 + 1"));
        System.out.println("3 ?= " + calculate(" 2-1 + 2 "));
        System.out.println("23 ?= " + calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
