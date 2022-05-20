package com.longluo.algorithm;

public class GCD {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcd_iter(int a, int b) {
        int remain = 1;
        while (remain != 0) {
            remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + gcd(10, 15));
        System.out.println("5 ?= " + gcd(15, 10));

        System.out.println("5 ?= " + gcd_iter(10, 15));
        System.out.println("5 ?= " + gcd_iter(15, 10));
        System.out.println("1 ?= " + gcd_iter(17, 12));
        System.out.println("1 ?= " + gcd_iter(12, 17));
    }
}
