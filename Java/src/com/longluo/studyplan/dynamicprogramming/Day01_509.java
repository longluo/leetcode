package com.longluo.studyplan.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Day01_509 {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + fib(1));
        System.out.println("1 ?= " + fib(2));
        System.out.println("2 ?= " + fib(3));
    }
}
