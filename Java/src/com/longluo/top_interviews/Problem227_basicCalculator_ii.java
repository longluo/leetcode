package com.longluo.top_interviews;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1]内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Problem227_basicCalculator_ii {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.replaceAll(" ", "");
        int n = s.length();
        int num = 0;
        char preSign = '+';
        Stack<Integer> numSt = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == n - 1) {
                if (preSign == '+') {
                    numSt.push(num);
                } else if (preSign == '-') {
                    numSt.push(-num);
                } else if (preSign == '*') {
                    int temp = numSt.pop();
                    numSt.push(temp * num);
                } else if (preSign == '/') {
                    int temp = numSt.pop();
                    numSt.push(temp / num);
                }

                num = 0;
                preSign = s.charAt(i);
            }
        }

        int res = 0;
        while (!numSt.empty()) {
            res += numSt.pop();
        }

        return res;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private static int operate(char ch, int numA, int numB) {
        int res = 0;
        switch (ch) {
            case '+':
                res = numA + numB;
                break;

            case '-':
                res = numA - numB;
                break;

            case '*':
                res = numB * numA;
                break;

            case '/':
                res = numB / numA;
                break;

            default:
                break;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + calculate("3+2*2"));
        System.out.println("1 ?= " + calculate(" 3/2 "));
        System.out.println("5 ?= " + calculate(" 3+5 / 2 "));
        System.out.println("42 ?= " + calculate("42"));
        System.out.println("1 ?= " + calculate("1-1+1"));
    }
}
