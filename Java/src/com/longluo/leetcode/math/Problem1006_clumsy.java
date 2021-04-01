package com.longluo.leetcode.math;

/**
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：
 * 乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：
 * 我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * <p>
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * <p>
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 * <p>
 * 示例 1：
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * <p>
 * 示例 2：
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 * <p>
 * 提示：
 * 1 <= N <= 10000
 * -2^31 <= answer <= 2^31 - 1（答案保证符合 32 位整数。）
 */
public class Problem1006_clumsy {

    public static int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N == 3) {
            return 6;
        }

        int cycle = N / 4;
        int ans = calFirstCycleValue(N);
        for (int i = 1; i < cycle; i++) {
            ans = ans - calACycleValue(N, i);
        }

        ans = ans - calYushu(N, cycle);

        return ans;
    }

    public static int calFirstCycleValue(int N) {
        return N * (N - 1) / (N - 2) + (N - 3);
    }

    public static int calACycleValue(int N, int cycleIdx) {
        int res = N - 4 * cycleIdx;
        return res * (res - 1) / (res - 2) - (res - 3);
    }

    public static int calYushu(int N, int cycle) {
        int yushu = N % 4;
        if (yushu == 1) {
            return 1;
        } else if (yushu == 2) {
            return 2;
        } else if (yushu == 3) {
            return 6;
        }

        return yushu;
    }

    public static int clumsy2(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + clumsy(0));
        System.out.println("1 ?= " + clumsy(1));
        System.out.println("2 ?= " + clumsy(2));
        System.out.println("6 ?= " + clumsy(3));
        System.out.println("7 ?= " + clumsy(4));
        System.out.println("12 ?= " + clumsy(10));

        System.out.println("0 ?= " + clumsy2(0));
        System.out.println("1 ?= " + clumsy2(1));
        System.out.println("2 ?= " + clumsy2(2));
        System.out.println("6 ?= " + clumsy2(3));
        System.out.println("7 ?= " + clumsy2(4));
        System.out.println("12 ?= " + clumsy2(10));
    }
}
