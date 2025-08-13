package com.longluo.misc.codejam;

/**
 * Google Code Jam 2008 Round1A ProblemC Numbers
 */
public class GoogleCodeJam_2008Round1A_ProblemC_Numbers {

    private static int[][] matrixMultiplication(int[][] A, int[][] B) {
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

    private static int[][] fastExponentiation(int[][] A, int n) {
        if (n == 1) {
            return A;
        }

        if (n % 2 == 0) {
            int[][] A_m = fastExponentiation(A, n / 2);
            return matrixMultiplication(A_m, A_m);
        } else {
            return matrixMultiplication(A, fastExponentiation(A, n - 1));
        }
    }

    private static String findLast3Digits(int n) {
        int[][] A = {{3, 5}, {1, 3}};

//        int[][] A_n = fastExponentiation(A, n);

        int[][] A_n = fastExponentiation(A, (n - 3) % 100 + 3);

        int result = (2 * A_n[0][0] + 999) % 1000;

        return String.format("%03d", result);
    }


    private static int[] multiply(int[] a, int[] b) {
        int[] c = new int[4];
        c[0] = (a[0] * b[0] + a[1] * b[2]) % 1000;
        c[1] = (a[0] * b[1] + a[1] * b[3]) % 1000;
        c[2] = (a[2] * b[0] + a[3] * b[2]) % 1000;
        c[3] = (a[2] * b[1] + a[3] * b[3]) % 1000;
        return c;
    }

    private static int fastMatrix(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 6;
        } else if (n == 2) {
            return 28;
        }

        n -= 2;

        int[] mat = {0, 1, 996, 6};
        int[] smat = mat.clone();

        while (n > 0) {
            if ((n & 1) == 1) {
                mat = multiply(mat, smat);
            }
            smat = multiply(smat, smat);
            n >>= 1;
        }

        return (mat[0] * 6 + mat[1] * 28) % 1000;
    }

    private static String findLast3Digits_rec(int n) {
//        int result = (fastMatrix(n) + 999) % 1000;
        int result = (fastMatrix((n - 3) % 100 + 3) + 999) % 1000;
        return String.format("%03d", result);
    }

    private static int quickMultiply(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 6;
        }

        n -= 2;

        int[][] mat = {{6, -4}, {1, 0}};
        int[][] smat = mat.clone();

        while (n > 0) {
            if ((n & 1) == 1) {
                mat = matrixMultiplication(mat, smat);
            }
            smat = matrixMultiplication(smat, smat);
            n >>= 1;
        }

        return (6 * mat[0][0] + 2 * mat[0][1]) % 1000;
    }

    private static String findLast3Digits_3(int n) {
//        int result = (quickMultiply((n - 3) % 100 + 3) + 999) % 1000;
        int result = (quickMultiply(n) + 999) % 1000;
        return String.format("%03d", result);
    }

    /**
     * Period is 25 from No. 3
     * 143 751 935 607 903 991 335 047 943 471 055 447 463 991 095 607 263 151 855 527 743 351 135 407 903
     */
    private static String findLast3Digits_4(int n) {
        int number = (n - 3) % 100 + 3;

        int mid = (752 + number * (number - 1) * (200 * number * number + 520)) % 1000;

        int result = (int) (((Math.pow(3, number) * mid) + 999) % 1000);

        return String.format("%03d", result);
    }

    /**
     * Period is 100 from No. 3
     * 005 027
     * 143 751 935 607 903 991 335 047 943 471 055 447 463 991 095 607 263 151 855 527 743 351 135 407 903 791 135 647 343 471 455 847 263 191 095 807 463 551 455 527 343 951 335 207 903 591 935 247 743 471 855 247 063 391 095 007 663 951 055 527 943 551 535 007 903 391 735 847 143 471 255 647 863 591 095 207 863 351 655 527 543 151 735 807 903 191 535 447 543 471 655 047 663 791 095 407 063 751 255 527
     */
    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            System.out.print(" " + findLast3Digits(i));
        }

        System.out.println();

        for (int i = 3; i < 103; i++) {
            System.out.print(" " + findLast3Digits(i));
        }

        System.out.println();

        for (int i = 103; i < 206; i++) {
            System.out.print(" " + findLast3Digits(i));
        }

        System.out.println("\n ================== Remainder ============= \n");

        for (int i = 3; i < 103; i++) {
            System.out.print(" " + findLast3Digits_4(i));
        }

        System.out.println();

        for (int i = 103; i < 206; i++) {
            System.out.print(" " + findLast3Digits_4(i));
        }

        /*
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

        System.out.println("\n ================== \n");

        System.out.println("005 ?= " + findLast3Digits_rec(1) + ", " + "005".equals(findLast3Digits_rec(1)));
        System.out.println("027 ?= " + findLast3Digits_rec(2) + ", " + "027".equals(findLast3Digits_rec(2)));
        System.out.println("143 ?= " + findLast3Digits_rec(3) + ", " + "143".equals(findLast3Digits_rec(3)));
        System.out.println("751 ?= " + findLast3Digits_rec(4) + ", " + "751".equals(findLast3Digits_rec(4)));
        System.out.println("935 ?= " + findLast3Digits_rec(5) + ", " + "935".equals(findLast3Digits_rec(5)));
        System.out.println("607 ?= " + findLast3Digits_rec(6) + ", " + "607".equals(findLast3Digits_rec(6)));
        System.out.println("647 ?= " + findLast3Digits_rec(30) + ", " + "647".equals(findLast3Digits_rec(30)));

        System.out.println("143 ?= " + findLast3Digits_rec(103) + ", " + "143".equals(findLast3Digits_rec(103)));
        System.out.println("743 ?= " + findLast3Digits_rec(1023) + ", " + "743".equals(findLast3Digits_rec(1023)));
        System.out.println("663 ?= " + findLast3Digits_rec(1999999995) + ", " + "663".equals(findLast3Digits_rec(1999999995)));

        System.out.println("\n ================== \n");

        System.out.println("005 ?= " + findLast3Digits_3(1) + ", " + "005".equals(findLast3Digits_3(1)));
        System.out.println("027 ?= " + findLast3Digits_3(2) + ", " + "027".equals(findLast3Digits_3(2)));
        System.out.println("143 ?= " + findLast3Digits_3(3) + ", " + "143".equals(findLast3Digits_3(3)));
        System.out.println("751 ?= " + findLast3Digits_3(4) + ", " + "751".equals(findLast3Digits_3(4)));
        System.out.println("935 ?= " + findLast3Digits_3(5) + ", " + "935".equals(findLast3Digits_3(5)));
        System.out.println("607 ?= " + findLast3Digits_3(6) + ", " + "607".equals(findLast3Digits_3(6)));
        System.out.println("647 ?= " + findLast3Digits_3(30) + ", " + "647".equals(findLast3Digits_3(30)));

        System.out.println("143 ?= " + findLast3Digits_3(103) + ", " + "143".equals(findLast3Digits_3(103)));
        System.out.println("743 ?= " + findLast3Digits_3(1023) + ", " + "743".equals(findLast3Digits_3(1023)));
        System.out.println("663 ?= " + findLast3Digits_3(1999999995) + ", " + "663".equals(findLast3Digits_3(1999999995)));

        System.out.println("\n ================== Remainder ============= \n");

        for (int i = 1; i < 105; i++) {
            System.out.print(" " + i + "," + findLast3Digits_4(i));
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println("005 ?= " + findLast3Digits_4(1) + ", " + "005".equals(findLast3Digits_4(1)));
        System.out.println("027 ?= " + findLast3Digits_4(2) + ", " + "027".equals(findLast3Digits_4(2)));
        System.out.println("143 ?= " + findLast3Digits_4(3) + ", " + "143".equals(findLast3Digits_4(3)));
        System.out.println("751 ?= " + findLast3Digits_4(4) + ", " + "751".equals(findLast3Digits_4(4)));
        System.out.println("935 ?= " + findLast3Digits_4(5) + ", " + "935".equals(findLast3Digits_4(5)));
        System.out.println("607 ?= " + findLast3Digits_4(6) + ", " + "607".equals(findLast3Digits_4(6)));
        System.out.println("647 ?= " + findLast3Digits_4(30) + ", " + "647".equals(findLast3Digits_4(30)));

        System.out.println("143 ?= " + findLast3Digits_4(103) + ", " + "143".equals(findLast3Digits_4(103)));
        System.out.println("743 ?= " + findLast3Digits_4(1023) + ", " + "743".equals(findLast3Digits_4(1023)));
        System.out.println("663 ?= " + findLast3Digits_4(1999999995) + ", " + "663".equals(findLast3Digits_4(1999999995)));
    */
    }
}
