package com.longluo.leetcode.string;

/**
 * 592. 分数加减运算
 * <p>
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。
 * 所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * 示例 1:
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 * <p>
 * 示例 2:
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * <p>
 * 示例 3:
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 * <p>
 * 提示:
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是[1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * <p>
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */
public class Problem592_fractionAdditionAndSubtraction {

    // Math
    // TODO: 2022/7/28  
    public static String fractionAddition(String expression) {
        int len = expression.length();

        long numerator = 1;
        long denominator = 1;
        int sign = 1;
        int idx = 0;
        while (idx < len) {


            denominator = 0;
            numerator = 1 + 0;
        }

        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("0/1 ?= " + fractionAddition("-1/2+1/2"));
        System.out.println("-1/6 ?= " + fractionAddition("1/3-1/2"));
    }
}
