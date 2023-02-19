package com.longluo.contest.biweekly_contest_98;

/**
 * https://leetcode.cn/contest/biweekly-contest-98
 */
public class Problem1 {

    public static int minMaxDifference(int num) {
        char[] array = String.valueOf(num).toCharArray();

        int n = array.length;

        char[] max = new char[n];
        char replace = ' ';
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '9') {
                max[i] = '9';
                continue;
            }

            if (array[i] != '9' && replace == ' ') {
                replace = array[i];
                max[i] = '9';
            } else if (replace != ' ' && array[i] == replace) {
                max[i] = '9';
            } else {
                max[i] = array[i];
            }
        }

        char[] min = new char[n];
        for (int i = 0; i < n; i++) {
            if (array[i] == array[0]) {
                min[i] = '0';
            } else {
                min[i] = array[i];
            }
        }

        return Integer.parseInt(new String(max)) - Integer.parseInt(new String(min));
    }

    public static void main(String[] args) {
        System.out.println("99 ?= " + minMaxDifference(90));
        System.out.println("99009 ?= " + minMaxDifference(11891));
    }
}
