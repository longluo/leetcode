package com.longluo.algorithm;

/**
 * KMP Algorithm
 */
public class KMP {

    private String target;
    private String pattern;

    public KMP(String target, String pattern) {
        this.target = target;
        this.pattern = pattern;
    }

    public static int Search_BruteForce(String targetStr, String patternStr) {
        int targetLen = targetStr.length();
        int patLen = patternStr.length();

        for (int i = 0; i < targetLen; i++) {
            if (targetStr.charAt(i) == patternStr.charAt(i)) {
                for (int j = 1; j < patLen; j++) {
                    if (targetStr.charAt(i + j) != patternStr.charAt(j)) {
                        break;
                    }

                    if (j == patLen - 1) {
                        return i;
                    }
                }

            }
        }

        return -1;
    }

    public static int ViolentMatch(String targetStr, String patternStr) {
        int targetLen = targetStr.length();
        int patLen = patternStr.length();

        int i = 0;
        int j = 0;
        while (i < targetLen && j < patLen) {
            if (targetStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == patLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int KMP(String target, String pattern) {
        int i = 0;
        int j = 0;
        int txtLen = target.length();
        int patLen = pattern.length();

        int[] next = buildNextArray(pattern);

        while (i < txtLen && j < patLen) {
            if (j == -1 || target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == patLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] buildNextArray(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = -1;
        int j = 0;
        while (j < len - 1) {
            if (i == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                i = next[i];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + Search_BruteForce("ababababca", "abababca"));
        System.out.println("2 ?= " + ViolentMatch("ababababca", "abababca"));

        System.out.println("2 ?= " + KMP("ababababca", "abababca"));

    }
}
