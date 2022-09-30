package com.longluo.lcci;

/**
 * 面试题 01.04. 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * <p>
 * https://leetcode.cn/problems/palindrome-permutation-lcci/
 */
public class Lcci_01_04_palindromePermutation {

    // Count time: O(n) space: O(128)
    public static boolean canPermutePalindrome(String s) {
        int[] cnt = new int[128];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int oddCnt = 0;
        for (int x : cnt) {
            if (x % 2 == 0) {
                continue;
            }

            oddCnt++;
        }

        return oddCnt <= 1;
    }

    // Bit time: O(n) space: O(1)
    public static boolean canPermutePalindrome_bit(String s) {
        long highBits = 0L;
        long lowBits = 0L;

        for (char ch : s.toCharArray()) {
            if (ch >= 64) {
                highBits ^= 1L << (ch - 64);
            } else {
                lowBits ^= 1L << ch;
            }
        }

        return Long.bitCount(highBits) + Long.bitCount(lowBits) <= 1;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canPermutePalindrome("tactcoa"));
        System.out.println("true ?= " + canPermutePalindrome_bit("tactcoa"));
    }
}
