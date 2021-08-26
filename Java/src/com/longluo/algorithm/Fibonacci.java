package com.longluo.algorithm;

/**
 *
 */
public class Fibonacci {

    public static int fib_1(int n) {
        if (n <= 1) {
            return n;
        }

        return fib_1(n - 1) + fib_1(n - 2);
    }


    public static int fib_2(int n) {
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

    public static int fib_4(int n) {
        int F[][] = new int[][]{{1, 1}, {1, 0}};
        if (n == 0) {
            return 0;
        }
        power(F, n - 1);
        return F[0][0];
    }

    /* Helper function that multiplies 2 matrices F and M of size 2*2, and
    puts the multiplication result back to F[][] */
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

    /* Helper function that calculates F[][] raise to the power n and puts the
    result in F[][]
    Note that this function is designed only for fib() and won't work as general
    power function */
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

    public static void main(String[] args) {

    }
}
