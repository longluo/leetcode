package com.longluo.studyplan.efficientwinning;

/**
 * 509. 斐波那契数
 * <p>
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Day03_509 {

    public static int fib(int n) {
        double sqrt5 =  Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fib_n / sqrt5);
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + fib(5));
    }
}
