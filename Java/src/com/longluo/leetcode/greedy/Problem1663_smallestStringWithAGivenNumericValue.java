package com.longluo.leetcode.greedy;

/**
 * 1663. Smallest String With A Given Numeric Value
 * <p>
 * Medium
 * <p>
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 * <p>
 * Example 1:
 * Input: n = 3, k = 27
 * Output: "aay"
 * Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
 * <p>
 * Example 2:
 * Input: n = 5, k = 73
 * Output: "aaszz"
 * <p>
 * Constraints:
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * <p>
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class Problem1663_smallestStringWithAGivenNumericValue {

    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = n; i >= 1; i--) {
            if (k - (i - 1) >= 26) {
                sb.append('z');
                k -= 26;
            } else {
                int idx = k - (i - 1);
                sb.append((char) ('a' + idx - 1));
                k -= idx;
            }
        }

        return sb.reverse().toString();
    }

    public static String getSmallestString_greedy(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        for (int rest = n; rest >= 1; rest--) {
            int bound = k - 26 * (rest - 1);
            if (bound > 0) {
                char ch = (char) (bound + 'a' - 1);
                sb.append(ch);
                k -= bound;
            } else {
                sb.append('a');
                k--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aay ?= " + getSmallestString(3, 27));
        System.out.println("aaszz ?= " + getSmallestString(5, 73));

        System.out.println("aay ?= " + getSmallestString_greedy(3, 27));
        System.out.println("aaszz ?= " + getSmallestString_greedy(5, 73));
    }
}
