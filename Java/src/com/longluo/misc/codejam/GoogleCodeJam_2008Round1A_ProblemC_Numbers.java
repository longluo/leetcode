package com.longluo.misc.codejam;

/**
 * Google Code Jam 2008 Round1A ProblemC Numbers
 */
public class GoogleCodeJam_2008Round1A_ProblemC_Numbers {

    private static int[][] matrix_multi(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null || A[0].length != B.length) {
            return null;
        }

        int rowA = A.length;
        int colA = A[0].length;

        int rowB = B.length;
        int colB = B[0].length;

        int[][] C = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                int sum = 0;
                for (int k = 0; k < colA; k++) {
                    sum += (A[i][k] * B[k][j]) % 1000;
                    sum = sum % 1000;
                }

                C[i][j] = sum % 1000;
            }
        }

        return C;
    }

    private static int[][] fast_exponentiation(int[][] A, int n) {
        if (n == 1) {
            return A;
        }

        if (n % 2 == 0) {
            int[][] A_m = fast_exponentiation(A, n / 2);
            return matrix_multi(A_m, A_m);
        } else {
            return matrix_multi(A, fast_exponentiation(A, n - 1));
        }
    }

    private static String findLast3Digits(int n) {
        int[][] A = {{3, 5}, {1, 3}};

        int[][] A_n = fast_exponentiation(A, n);

        int result = (2 * A_n[0][0] + 999) % 1000;

        StringBuilder sb = new StringBuilder(3);

        if (result > 100) {
            sb.append(result);
        } else if (result > 10) {
            sb.append("0").append(result);
        } else {
            sb.append("00").append(result);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("005 ?= " + findLast3Digits(1) + ", " + "005".equals(findLast3Digits(1)));
        System.out.println("027 ?= " + findLast3Digits(2) + ", " + "027".equals(findLast3Digits(2)));
        System.out.println("143 ?= " + findLast3Digits(3) + ", " + "143".equals(findLast3Digits(3)));
        System.out.println("751 ?= " + findLast3Digits(4) + ", " + "751".equals(findLast3Digits(4)));
        System.out.println("935 ?= " + findLast3Digits(5) + ", " + "935".equals(findLast3Digits(5)));
        System.out.println("607 ?= " + findLast3Digits(6) + ", " + "607".equals(findLast3Digits(6)));
        System.out.println("647 ?= " + findLast3Digits(30) + ", " + "647".equals(findLast3Digits(30)));

        System.out.println("143 ?= " + findLast3Digits(103) + ", " + "143".equals(findLast3Digits(103)));
        System.out.println("743 ?= " + findLast3Digits(1023) + ", " + "743".equals(findLast3Digits(1023)));
        System.out.println("663 ?= " + findLast3Digits(1999999995) + ", " + "663".equals(findLast3Digits(1999999995)));

    }
}
