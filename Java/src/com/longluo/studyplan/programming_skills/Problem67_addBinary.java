package com.longluo.studyplan.programming_skills;

public class Problem67_addBinary {

    // BF API time: O(n) space: O(1)
    // The Length Too long Failed
    public static String addBinary_api(String a, String b) {
        int numA = Integer.parseInt(a, 2);
        int numB = Integer.parseInt(b, 2);
        int ans = numA + numB;
        return Integer.toBinaryString(ans);
    }

    // BF time: O(n) space: O(1)
    public static String addBinary_bf_bit(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int p = lenA - 1;
        int q = lenB - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p >= 0 || q >= 0) {
            int numA = p >= 0 ? a.charAt(p) - '0' : 0;
            int numB = q >= 0 ? b.charAt(q) - '0' : 0;
            int sum = numA + numB + carry;
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
            p--;
            q--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("100 ?= " + addBinary_api("11", "1"));
        System.out.println("10101 ?= " + addBinary_api("1010", "1011"));

        System.out.println("100 ?= " + addBinary_bf_bit("11", "1"));
        System.out.println("10101 ?= " + addBinary_bf_bit("1010", "1011"));
    }
}
