package com.longluo.algorithm;

public class FFT {

    public int[] mutply(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int[] C = new int[n + m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                C[i + j] += A[i] * B[j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            System.out.print(" " + (int) (Math.log(i) / Math.log(2)));
        }

        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + Integer.toBinaryString(i));
        }

        for (int i = 0; i < 10; i++) {
            double x = 1 + 0.1 * i;
            double cos = 1 - Math.pow(x * Math.sin(0.5), 2);
            double y = Math.sqrt(cos) / Math.cos(0.5);
            System.out.println(" " + x + " " + y);
        }
    }
}
