package com.longluo.top_interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * <p>
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * <p>
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * <p>
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * <p>
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * <p>
 * 提示：
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 * <p>
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class Problem166_fractionToDecimal {

    public static String fractionToDecimal(int _numerator, int _denominator) {
        if (_numerator == 0) {
            return "0";
        } else if (_numerator == _denominator) {
            return "1";
        }

        long numerator = _numerator;
        long denominator = _denominator;
        boolean isNegative = false;
        if (numerator > 0 && denominator < 0) {
            denominator = -denominator;
            isNegative = true;
        } else if (numerator < 0 && denominator > 0) {
            numerator = -numerator;
            isNegative = true;
        } else if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        if (numerator % denominator == 0) {
            if (isNegative) {
                return String.valueOf(-numerator / denominator);
            } else {
                return String.valueOf(numerator / denominator);
            }
        }

        StringBuilder integerPart = new StringBuilder();
        if (numerator < denominator) {
            integerPart.append("0");
        } else {
            integerPart.append(numerator / denominator);
        }

        StringBuilder decimalPart = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        long remainder = numerator % denominator;
        boolean isContainCycle = false;
        int startIdx = 0;
        while (remainder != 0) {
            map.put(remainder, decimalPart.length());
            remainder = remainder * 10;
            while (remainder < denominator) {
                remainder = remainder * 10;
                decimalPart.append("0");
            }
            if (remainder % denominator == 0) {
                decimalPart.append(remainder / denominator);
                break;
            }
            long quotient = remainder / denominator;
            decimalPart.append(quotient);
            remainder = remainder % denominator;
            if (map.containsKey(remainder)) {
                isContainCycle = true;
                startIdx = map.get(remainder);
                break;
            } else {
                map.put(remainder, decimalPart.length());
            }
        }

        String decimalStr;
        if (isContainCycle) {
            if (startIdx == 0) {
                decimalStr = "(" + decimalPart.toString() + ")";
            } else {
                decimalStr = decimalPart.toString().substring(0, startIdx) + "(" + decimalPart.toString().substring(startIdx) + ")";
            }
        } else {
            decimalStr = decimalPart.toString();
        }

        String res;
        if (isNegative) {
            res = "-" + integerPart.toString() + "." + decimalStr;
        } else {
            res = integerPart.toString() + "." + decimalStr;
        }

        return res;
    }

    public static String fractionToDecimal_opt(int _numerator, int _denominator) {
        if (_numerator == 0) {
            return "0";
        } else if (_numerator == _denominator) {
            return "1";
        }

        long numerator = _numerator;
        long denominator = _denominator;

        boolean isNegative = false;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            isNegative = true;
        }

        if (numerator < 0) {
            numerator = -numerator;
        }

        if (denominator < 0) {
            denominator = -denominator;
        }

        if (numerator % denominator == 0) {
            long res = numerator / denominator;
            return isNegative ? String.valueOf(-res) : String.valueOf(res);
        }

        StringBuilder integerPart = new StringBuilder();
        integerPart.append(numerator / denominator);

        StringBuilder decimalPart = new StringBuilder();

        Map<Long, Integer> map = new HashMap<>();
        long remainder = numerator % denominator;
        boolean isContainCycle = false;
        int startIdx = 0;
        while (remainder != 0) {
            map.put(remainder, decimalPart.length());
            remainder = remainder * 10;
            while (remainder < denominator) {
                remainder = remainder * 10;
                decimalPart.append("0");
            }
            if (remainder % denominator == 0) {
                decimalPart.append(remainder / denominator);
                break;
            }
            long quotient = remainder / denominator;
            decimalPart.append(quotient);
            remainder = remainder % denominator;
            if (map.containsKey(remainder)) {
                isContainCycle = true;
                startIdx = map.get(remainder);
                break;
            } else {
                map.put(remainder, decimalPart.length());
            }
        }

        String decimalStr;
        if (isContainCycle) {
            if (startIdx == 0) {
                decimalStr = "(" + decimalPart.toString() + ")";
            } else {
                decimalStr = decimalPart.substring(0, startIdx) + "(" + decimalPart.substring(startIdx) + ")";
            }
        } else {
            decimalStr = decimalPart.toString();
        }

        String res;
        if (isNegative) {
            res = "-" + integerPart.toString() + "." + decimalStr;
        } else {
            res = integerPart.toString() + "." + decimalStr;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("0.5 ?= " + fractionToDecimal(1, 2));
        System.out.println("1 ?= " + fractionToDecimal(1, 1));
        System.out.println("0 ?= " + fractionToDecimal(0, 1));
        System.out.println("2 ?= " + fractionToDecimal(2, 1));
        System.out.println("0.(012) ?= " + fractionToDecimal(4, 333));
        System.out.println("0.2 ?= " + fractionToDecimal(1, 5));
        System.out.println("-6.25 ?= " + fractionToDecimal(-50, 8));
        System.out.println("0.0000000004656612873077392578125 ?= " + fractionToDecimal(-1, -2147483648));
        System.out.println("2147483648 ?= " + fractionToDecimal(-2147483648, -1));
        System.out.println("-2147483648 ?= " + fractionToDecimal(-2147483648, 1));
        System.out.println("-2147483648 ?= " + fractionToDecimal_opt(-2147483648, 1));
        System.out.println("-0.(1) ?= " + fractionToDecimal_opt(-1, 9));
    }
}
