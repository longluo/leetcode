package com.longluo.leetcode.math;

/**
 * 640. 求解方程
 * <p>
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 * 示例 1：
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * <p>
 * 示例 2:
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * <p>
 * 示例 3:
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * <p>
 * 提示:
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 * <p>
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class Problem640_solveTheEquation {

    // TODO: 2022/8/11  
    // Simulate time: O(n) space: O(n)
    public static String solveEquation(String equation) {
        int len = equation.length();
        int index = 0;

        int factor = 0;
        int value = 0;

        int signLeft = 1;
        while (index < len) {
            if (equation.charAt(index) == '=') {
                signLeft = -1;
                index++;
                continue;
            }

            int signRight = signLeft;
            int number = 0;
            boolean valid = false;
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') {
                signRight = (equation.charAt(index) == '-') ? -signLeft : signLeft;
                index++;
            }

            while (index < len && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }

            if (index < len && equation.charAt(index) == 'x') {
                factor += valid ? signRight * number : signRight;
                index++;
            } else {
                value += signRight * number;
            }
        }

        if (factor == 0) {
            return value == 0 ? "Infinite solutions" : "No solution";
        }

        return "x=" + (-value / factor);
    }

    public static void main(String[] args) {
        System.out.println("x=2 ?= " + solveEquation("x+5-3+x=6+x-2"));
        System.out.println("x=0 ?= " + solveEquation("2x=x"));
        System.out.println("Infinite solutions ?= " + solveEquation("x=x"));
    }
}
