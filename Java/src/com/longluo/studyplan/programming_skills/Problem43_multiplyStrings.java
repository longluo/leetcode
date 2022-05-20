package com.longluo.studyplan.programming_skills;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 * <p>
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Problem43_multiplyStrings {

    // BigInteger time: O(m * n) space: O(m + n)
    public static String multiply_big(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        BigInteger ans = numA.multiply(numB);
        return ans.toString();
    }

    // Simulate time: O(m * n) space: O(m + n)
    public static String multiply_simu(String num1, String num2) {
        int lenA = num1.length();
        int lenB = num2.length();
        if (lenA == 0 || lenB == 0) {
            return "0";
        }

        int[] res = new int[lenA + lenB];
        int p = 0;
        int q = 0;
        for (int i = lenA - 1; i >= 0; i--) {
            int carry = 0;
            int numA = num1.charAt(i) - '0';
            q = 0;
            for (int j = lenB - 1; j >= 0; j--) {
                int numB = num2.charAt(j) - '0';
                int sum = numA * numB + res[p + q] + carry;
                res[p + q] = sum % 10;
                carry = sum / 10;
                q++;
            }

            if (carry > 0) {
                res[p + q] += carry;
            }
            p++;
        }

        int len = res.length - 1;
        while (len >= 0 && res[len] == 0) {
            len--;
        }

        if (len == -1) {
            return "0";
        }

        StringBuilder sb = new StringBuilder(len);
        while (len >= 0) {
            sb.append(res[len]);
            len--;
        }

        return sb.toString();
    }

    // NTT time: O((m+n)log(m+n)) space: O(m + n)
    static final long MOD = 998244353;
    static final long G = 3;
    static final long G_INV = (MOD + 1) / 3;

    static int[] rev;

    public static String multiply_ntt(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();

        int n = 1;
        while (n < len1 + len2) {
            n = n << 1;
        }

        long A[] = new long[n];
        long B[] = new long[n];

        for (int i = 0; i < len1; i++) {
            A[i] = num1.charAt(len1 - 1 - i) - '0';
        }

        for (int i = 0; i < len2; i++) {
            B[i] = num2.charAt(len2 - 1 - i) - '0';
        }

        rev = new int[n];

        for (int i = 0; i < n; i++) {
            rev[i] = rev[i >> 1] >> 1;
            if ((i & 1) == 1) {
                rev[i] |= n / 2;
            }
        }

        NTT(A, false);
        NTT(B, false);

        for (int i = 0; i < n; i++) {
            A[i] = A[i] * B[i] % MOD;
        }

        NTT(A, true);

        StringBuilder ans = new StringBuilder();
        long carry = 0;
        for (int i = 0; i < n; i++) {
            long sum = (A[i] + carry) % MOD;
            carry = sum / 10;
            ans.append((char) (sum % 10 + '0'));
        }

        while (carry > 0) {
            ans.append((char) (carry % 10 + '0'));
            carry /= 10;
        }

        int idx = n - 1;
        while (idx >= 0 && ans.charAt(idx) == '0') {
            ans.deleteCharAt(idx--);
        }

        return ans.reverse().toString();
    }

    public static long quickPower(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }

            a = a * a % MOD;
            b = b >> 1;
        }

        return res % MOD;
    }

    public static void NTT(long a[], boolean invert) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i < rev[i]) {
                long temp = a[i];
                a[i] = a[rev[i]];
                a[rev[i]] = temp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            long wlen = quickPower(invert ? G_INV : G, (MOD - 1) / len);
            for (int i = 0; i < n; i += len) {
                long w = 1L;
                for (int j = 0; j < len / 2; j++) {
                    long u = a[i + j];
                    long v = w * a[i + j + len / 2] % MOD;
                    a[i + j] = (u + v) % MOD;
                    a[i + j + len / 2] = (u - v + MOD) % MOD;
                    w = w * wlen % MOD;
                }
            }
        }

        if (invert) {
            long inver = quickPower(n, MOD - 2);
            for (int i = 0; i < n; i++) {
                a[i] = a[i] * inver % MOD;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("56088 ?= " + multiply_big("123", "456"));
        System.out.println("97406784 ?= " + multiply_big("123456", "789"));
        System.out.println("111111102 ?= " + multiply_big("12345678", "9"));
        System.out.println("56088 ?= " + multiply_simu("123", "456"));
        System.out.println("0 ?= " + multiply_simu("0", "0"));

        System.out.println("56088 ?= " + multiply_ntt("123", "456"));
        System.out.println("2040 ?= " + multiply_ntt("408", "5"));
    }
}
