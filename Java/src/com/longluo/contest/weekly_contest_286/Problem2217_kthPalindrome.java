package com.longluo.contest.weekly_contest_286;

/**
 * 2217. 找到指定长度的回文数
 * <p>
 * 给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
 * <p>
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 * <p>
 * 示例 1：
 * 输入：queries = [1,2,3,4,5,90], intLength = 3
 * 输出：[101,111,121,131,141,999]
 * 解释：
 * 长度为 3 的最小回文数依次是：
 * 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
 * 第 90 个长度为 3 的回文数是 999 。
 * <p>
 * 示例 2：
 * 输入：queries = [2,4,6], intLength = 4
 * 输出：[1111,1331,1551]
 * 解释：
 * 长度为 4 的前 6 个回文数是：
 * 1001, 1111, 1221, 1331, 1441 和 1551 。
 * <p>
 * 提示：
 * 1 <= queries.length <= 5 * 104
 * 1 <= queries[i] <= 109
 * 1 <= intLength <= 15
 * <p>
 * <p>
 * https://leetcode.cn/problems/find-palindrome-with-fixed-length/
 */
public class Problem2217_kthPalindrome {

    // TODO: 2022/6/2  
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
