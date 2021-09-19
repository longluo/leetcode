package com.longluo.leetcode.math;

public class Problem650_minSteps {

    public static int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }

        return ans;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        if (n == 2) {
            return true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minSteps(1));
        System.out.println("2 ?= " + minSteps(2));
        System.out.println("3 ?= " + minSteps(3));
        System.out.println("4 ?= " + minSteps(4));
        System.out.println("5 ?= " + minSteps(5));
        System.out.println("5 ?= " + minSteps(6));
        System.out.println("7 ?= " + minSteps(7));
        System.out.println("6 ?= " + minSteps(8));
        System.out.println("6 ?= " + minSteps(9));
        System.out.println("7 ?= " + minSteps(10));
    }
}
