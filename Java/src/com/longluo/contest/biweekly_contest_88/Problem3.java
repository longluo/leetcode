package com.longluo.contest.biweekly_contest_88;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int xor1 = 0;
        for (int i = 0; i < len1; i++) {
            xor1 ^= nums1[i];
        }

        int xor2 = 0;
        for (int i = 0; i < len2; i++) {
            xor2 ^= nums2[i];
        }

        if (len1 % 2 == 1 && len2 % 2 == 1) {
            return xor1 ^ xor2;
        } else if (len1 % 2 == 0 && len2 % 2 == 0) {
            return 0;
        } else if (len1 % 2 == 1 && len2 % 2 == 0) {
            return xor2;
        } else if (len1 % 2 == 0 && len2 % 2 == 1) {
            return xor1;
        }

        return 0;
    }

    public int xorAllNums_2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int xor1 = 0;
        int xor2 = 0;

        for (int x : nums1) {
            xor1 ^= x;
        }

        for (int x : nums2) {
            xor2 ^= x;
        }

        if (m % 2 == 0 && n % 2 == 0) {
            return 0;
        } else if (m % 2 == 0 && n % 2 == 1) {
            return xor1;
        } else if (m % 2 == 1 && n % 2 == 0) {
            return xor2;
        } else {
            return xor1 ^ xor2;
        }
    }

    public static void main(String[] args) {
        System.out.println(10 ^ 2 ^ 5);
    }
}
