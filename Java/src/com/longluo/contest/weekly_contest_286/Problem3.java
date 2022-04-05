package com.longluo.contest.weekly_contest_286;

public class Problem3 {

    public static long[] kthPalindrome(int[] queries, int intLength) {
        int len = queries.length;
        long[] ans = new long[len];
        if (intLength <= 1) {
            for (int i = 0; i <= len; i++) {
                if (queries[i] > 10) {
                    ans[i] = -1;
                } else {
                    ans[i] = queries[i];
                }
            }

            return ans;
        }

        long max = (long) (Math.pow(10, intLength) - 1);
        int[] array = new int[intLength];
        array[0] = array[intLength - 1] = 1;
        for (int i = 0; i < len; i++) {
            ans[i] = getNumber(array, max, queries[i]);
        }

        return ans;
    }

    public static long getNumber(int[] start, long max, int k) {
        long ans = 0;
        int len = start.length;
        int total = 0;
        if (len % 2 == 0) {
            total = 9;
        } else {

        }

        return getNum(start);
    }

    public static long getNum(int[] array) {
        long res = 0;
        for (int i = 0; i < array.length; i++) {
            res = 10 * res + array[0];
        }

        return res;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println("" + String.valueOf(Integer.MAX_VALUE).length());
        System.out.println("" + String.valueOf(Long.MAX_VALUE).length());
        System.out.println("" + (Math.pow(10, 0) + 1));
        System.out.println("" + (Math.pow(10, 1) + 1));
        System.out.println("" + (Math.pow(10, 1) - 1));
        System.out.println("" + (Math.pow(10, 2) - 1));
    }
}
