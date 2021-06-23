package com.longluo.interview;

/**
 * 面试题 05.06. 整数转换
 * <p>
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * <p>
 * 示例2:
 * 输入：A = 1，B = 2
 * 输出：2
 * <p>
 * 提示:
 * A，B范围在[-2147483648, 2147483647]之间
 * <p>
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 */
public class Interview_05_06_convert_integer_lcci {

    public static int convertInteger(int A, int B) {
        int count = 0;
        int xor = A ^ B;
        while (xor != 0) {
            xor &= xor - 1;
            count++;
        }

        return count;
    }

    public static int convertInteger_2(int A, int B) {
        int count = 0;
        int xor = A ^ B;
        for (int i = 0; i < 32; i++) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor = xor >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + convertInteger(29, 15));
        System.out.println("2 ?= " + convertInteger_2(29, 15));
        System.out.println("2 ?= " + convertInteger(1, 2));
        System.out.println("2 ?= " + convertInteger_2(1, 2));
    }
}
