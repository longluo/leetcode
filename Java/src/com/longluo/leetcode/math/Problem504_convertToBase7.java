package com.longluo.leetcode.math;

/**
 * 504. 七进制数
 * <p>
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 * <p>
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * 提示：
 * -10^7 <= num <= 10^7
 * <p>
 * https://leetcode-cn.com/problems/base-7/
 */
public class Problem504_convertToBase7 {

    public static String convertToBase7(int num) {
        if (num >= -6 && num <= 6) {
            return String.valueOf(num);
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        if (flag) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static String convertToBase7_opt(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (isNegative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + convertToBase7(0));
        System.out.println("5 ?= " + convertToBase7(5));
        System.out.println("10 ?= " + convertToBase7(7));
        System.out.println("11 ?= " + convertToBase7(8));
        System.out.println("-10 ?= " + convertToBase7(-7));
        System.out.println("202 ?= " + convertToBase7(100));

        System.out.println("-10 ?= " + convertToBase7_opt(-7));
        System.out.println("202 ?= " + convertToBase7_opt(100));
    }
}
