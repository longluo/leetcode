package com.longluo.contest.weekly_contest_315;

public class Problem3 {

    public static boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }

        for (int i = 1; i < num; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int rev = Integer.parseInt(sb.reverse().toString());
            if (i + rev == num) {
                return true;
            }
        }

        return false;
    }

    public static boolean sumOfNumberAndReverse_opt(int num) {
        for (int i = 0; i <= num; i++) {
            String revertStr = reverseString(String.valueOf(i));
            int revert = Integer.parseInt(revertStr);
            if (i + revert == num) {
                return true;
            }
        }

        return false;
    }

    private static String reverseString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println("  ?= " + sumOfNumberAndReverse(443));
        System.out.println("  ?= " + sumOfNumberAndReverse(63));
        System.out.println("  ?= " + sumOfNumberAndReverse(181));

        System.out.println("true ?= " + sumOfNumberAndReverse_opt(0));
        System.out.println("false ?= " + sumOfNumberAndReverse_opt(1));
    }
}
