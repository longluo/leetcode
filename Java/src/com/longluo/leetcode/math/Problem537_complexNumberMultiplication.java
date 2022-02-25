package com.longluo.leetcode.math;

/**
 * 537. 复数乘法
 * <p>
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i^2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 * <p>
 * 示例 1：
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * <p>
 * 示例 2：
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * <p>
 * 提示：
 * num1 和 num2 都是有效的复数表示。
 * <p>
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 */
public class Problem537_complexNumberMultiplication {

    public static String complexNumberMultiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] complexNum1 = getComplexNumber(num1);
        int[] complexNum2 = getComplexNumber(num2);
        int realPart = complexNum1[0] * complexNum2[0] - complexNum1[1] * complexNum2[1];
        int imagPart = complexNum1[0] * complexNum2[1] + complexNum1[1] * complexNum2[0];
        sb.append(realPart).append("+").append(imagPart).append("i");
        return sb.toString();
    }

    public static int[] getComplexNumber(String number) {
        int[] res = new int[2];
        int len = number.length();
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) == '+') {
                res[0] = Integer.parseInt(number.substring(0, i));
                res[1] = Integer.parseInt(number.substring(i + 1, len - 1));
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("0+2i ?= " + complexNumberMultiply("1+1i", "1+1i"));
        System.out.println("0+-2i ?= " + complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
