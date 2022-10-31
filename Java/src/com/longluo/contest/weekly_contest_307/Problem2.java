package com.longluo.contest.weekly_contest_307;

/**
 * https://leetcode.cn/problems/largest-palindromic-number/
 */
public class Problem2 {

    public static String largestPalindromic(String num) {
        int[] count = new int[10];
        for (char ch : num.toCharArray()) {
            int digit = ch - '0';
            count[digit]++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (i > 0 && count[i] > 1) {
                prefix.append(i);
                count[i] -= 2;
            }

            if (i == 0 && prefix.length() > 0) {
                while (count[0] >= 2) {
                    prefix.append(0);
                    count[0] -= 2;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(prefix);

        for (int i = 9; i >= 0; i--) {
            if (i > 0 && count[i] > 0) {
                ans.append(i);
                break;
            } else if (i == 0 && count[0] > 0 && ans.length() >= 0) {
                ans.append(0);
                break;
            }
        }

        ans.append(prefix.reverse());

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + largestPalindromic("0000"));
        System.out.println("6006 ?= " + largestPalindromic("6006"));
        System.out.println("7449447 ?= " + largestPalindromic("444947137"));
        System.out.println("9 ?= " + largestPalindromic("00009"));
    }
}
