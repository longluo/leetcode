package com.longluo.algorithm;

/**
 * Fibonacci Algorithms
 *
 * @author longluo
 * @date 2021-7-23
 */
public class Fibonacci {

    int[] nums = {
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
            6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
            1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986,
            102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903
    };

    public int fib_table(int n) {
        return nums[n];
    }

    /**
     * The Fibonacci Recursive Method
     *
     * @param n
     * @return the nth fibonacci number
     */
    public static long fib_recursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    /**
     * @param time
     * @return
     */
    public static int recursion_time(long time) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        int i = 2;
        while (endTime < startTime + time * 1000) {
            endTime = System.currentTimeMillis();
            i++;
            fib_recursive(i);
        }

        return i;
    }

    /**
     * 测试递归法在1，5，10，50秒内使用迭代法算出的最大斐波那契数是第几个
     */
    public static void time_recursion_test() {
        long t1 = System.currentTimeMillis();
        long t2 = 0;
        int i = 3;
        for (; t2 - t1 > 60000; ) {
            fib_recursive(i);
            i++;
            t2 = System.currentTimeMillis();
            if (t2 - t1 == 1000) {
                System.out.println("1秒内最大斐波那契数是第：" + i + "个 ");
            }
            if (t2 - t1 == 5000) {
                System.out.println("5秒内最大斐波那契数是第：" + i + "个 ");
            }
            if (t2 - t1 == 10000) {
                System.out.println("10秒内最大斐波那契数是第：" + i + "个 ");
            }
            if (t2 - t1 == 50000) {
                System.out.println("50秒内最大斐波那契数是第：" + i + "个 ");
            }
        }
    }

    /**
     * 递归法在1，5，10，50秒内算出的最大斐波那契数是第几个
     */
    public static void fib_recursion_time() {
        System.out.println("The Max Fibonacci Number in 1 second is the " + recursion_time(1));
        System.out.println("The Max Fibonacci Number in 5 second is the " + recursion_time(5));
        System.out.println("The Max Fibonacci Number in 10 second is the " + recursion_time(10));
        System.out.println("The Max Fibonacci Number in 50 second is the " + recursion_time(50));
    }

    /**
     * The Dynamic Programming Method To Calculate the Fibonacci Numbers
     * <p>
     * The Iteration Method
     *
     * @param n
     * @return
     */
    public static int fib_dp(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            /* Add the previous 2 numbers in the series and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /**
     * 用迭代法寻找编程环境支持的最大整数(int型)的斐波那契数是第几个斐波那契数
     *
     * @return
     */
    public static int max_int_iteration() {
        int p = 1;
        int q = 1;
        int r = 2;
        int count = 3;
        /* 一旦c达到编程环境最大斐波那契数，便会产生内存溢出，从而变成一个负数，到此循环结束 */
        for (; q < r; ) {
            p = q;
            q = r;
            r = p + q;
            count++;
        }

        return count;
    }

    /**
     * 用迭代法寻找编程环境支持的最大整数(long型)的斐波那契数是第几个斐波那契数
     *
     * @return
     */
    public static long max_long_iteration() {
        long a = 1, b = 1, c = 2;
        long count = 3;
        /* 一旦c达到编程环境最大斐波那契数，便会产生内存溢出，从而变成一个负数，到此循环结束 */
        for (; b < c; ) {
            a = b;
            b = c;
            c = a + b;
            count++;
        }

        return count;
    }

    /**
     * 在1，5，10，50秒内使用迭代法算出的最大斐波那契数是第几个
     */
    public static void time_iteration() {
        long t1 = System.currentTimeMillis();
        long t2 = System.currentTimeMillis();

        int a = 1;
        int b = 1;
        int c = 2;

        long a1 = 0, a2 = 0, a3 = 0, a4 = 0;

        long count = 3;
        for (; t2 - t1 < 60000; ) {
            a = b;
            b = c;
            c = a + b;
            count++;
            t2 = System.currentTimeMillis();
            if (t2 - t1 == 1000) {
                a1 = count;
            }

            if (t2 - t1 == 5000) {
                a2 = count;
            }

            if (t2 - t1 == 10000) {
                a3 = count;
            }

            if (t2 - t1 == 50000) {
                a4 = count;
            }
        }

        System.out.println("迭代法1秒内最大斐波那契数是第：" + a1 + "个 ");
        System.out.println("迭代法5秒内最大斐波那契数是第：" + a2 + "个 ");
        System.out.println("迭代法10秒内最大斐波那契数是第：" + a3 + "个 ");
        System.out.println("迭代法50秒内最大斐波那契数是第：" + a4 + "个 ");
    }

    /**
     * @param n
     * @return
     */
    public static int fib_4(int n) {
        int F[][] = new int[][]{{1, 1}, {1, 0}};
        if (n == 0) {
            return 0;
        }
        power(F, n - 1);
        return F[0][0];
    }

    /**
     * Helper function that multiplies 2 matrices F and M of size 2*2,
     * and puts the multiplication result back to F[][]
     *
     * @param F
     * @param M
     */
    public static void multiply(int F[][], int M[][]) {
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /**
     * Helper function that calculates F[][] raise to the power n and puts the result in F[][]
     * Note that this function is designed only for fib() and won't work as general power function
     *
     * @param F
     * @param n
     */
    public static void power(int F[][], int n) {
        int i;
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }

    public static int MAX = 1000;
    public static int f[];

    // Returns n'th fibonacci number using
    // table f[]
    public static int fib_7(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return (f[n] = 1);
        }

        // If fib(n) is already computed
        if (f[n] != 0) {
            return f[n];
        }

        int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

        // Applying above formula [Note value n&1 is 1 if n is odd, else 0.
        f[n] = (n & 1) == 1 ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) : (2 * fib(k - 1) + fib(k)) * fib(k);

        return f[n];
    }

    // Initialize array of dp
    public static int[] dp = new int[10];

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // Temporary variables to store values of fib(n-1) & fib(n-2)
        int first, second;

        if (dp[n - 1] != -1) {
            first = dp[n - 1];
        } else {
            first = fib(n - 1);
        }

        if (dp[n - 2] != -1) {
            second = dp[n - 2];
        } else {
            second = fib(n - 2);
        }

        // Memoization
        return dp[n] = first + second;
    }

    /**
     * @param n
     * @return
     */
    public static int fib_new(int n) {
        int result = 0;

        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else if (n == 3) {
            result = 2;
        } else if (n >= 4) {
            int divisor = n / 4;
            int remainer = n % 4;
            int a = fib_new(divisor);
            int b = fib_new((divisor + 1));
            int c = fib_new((divisor - 1));
            int d = fib_new((divisor + 2));
            if (remainer == 0) {
                result = (int) ((Math.pow(b, 2) - Math.pow(c, 2)) * (Math.pow(c, 2) + 2 * Math.pow(a, 2) + Math.pow(b, 2)));
            }
            if (remainer == 1) {
                result = (int) (Math.pow((Math.pow(b, 2) - Math.pow(c, 2)), 2) + Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), 2));
            }
            if (remainer == 2) {
                result = (int) ((Math.pow(a, 2) + Math.pow(b, 2)) * (3 * Math.pow(b, 2) + Math.pow(a, 2) - 2 * Math.pow(c, 2)));
            }
            if (remainer == 3) {
                result = (int) (Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), 2) + Math.pow((Math.pow(d, 2) - Math.pow(a, 2)), 2));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(max_int_iteration());
        System.out.println(max_long_iteration());

        long t1 = System.currentTimeMillis();
        long result = fib_recursive(47);
        long t2 = System.currentTimeMillis();
        System.out.println("递归法求斐波那契数：" + result);
        System.out.println("递归算法Time is: " + (t2 - t1) / 1000.0 + "  second");
    }
}
