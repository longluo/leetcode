package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. 给表达式添加运算符
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或*，
 * 返回所有能够得到目标值的表达式。
 * <p>
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * <p>
 * 示例 2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * <p>
 * 示例 3:
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * <p>
 * 示例 4:
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * <p>
 * 示例 5:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * <p>
 * 提示：
 * 1 <= num.length <= 10
 * num 仅含数字
 * -2^31 <= target <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/expression-add-operators/
 */
public class Problem282_expressionAddOperators {

    static int n;
    static String num;
    static int target;
    static List<String> ans;

    public static List<String> addOperators(String num, int target) {
        n = num.length();
        num = num;
        target = target;
        ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    public static void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) { // 表达式开头不能添加符号
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }

    public static void main(String[] args) {
        System.out.println("[1+2+3, 1*2*3] ?= " + addOperators("123", 6));
        System.out.println("[2*3+2, 2+3*2] ?= " + addOperators("232", 8));
        System.out.println("[1*0+5, 10-5] ?= " + addOperators("105", 5));
        System.out.println("[0+0, 0-0, 0*0] ?= " + addOperators("00", 0));
        System.out.println("[] ?= " + addOperators("3456237490", 9191));
    }
}
