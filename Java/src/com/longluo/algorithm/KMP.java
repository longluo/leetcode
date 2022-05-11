package com.longluo.algorithm;

import java.util.Arrays;

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
                if (pattern.charAt(i) != pattern.charAt(j)) {
                    next[j] = i;
                } else {
                    //因为不能出现p[j] = p[next[j]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[i];
                }
            } else {
                i = next[i];
            }
        }

        return next;
    }


    public static int[] getNext(String needle) {
        int len = needle.length();

        //  定义好next数组
        int[] next = new int[len];

        for (int right = 1, left = 0; right < len; right++) {
            // 定义好两个指针right与left
            // 在for循环中初始化指针right为1，left=0,开始计算next数组，right始终在left指针的后面
            while (left > 0 && needle.charAt(left) != needle.charAt(right)) {
                // 如果不相等就让left指针回退，到0时就停止回退
                left = next[left - 1]; //进行回退操作；
            }

            if (needle.charAt(left) == needle.charAt(right)) {
                left++;
            }

            next[right] = left;   // 这是从 1 开始的
        }

        return next;
    }

    public static int[] getNext_carl(String needle) {
        int len = needle.length();
        int j = 0;
        int[] next = new int[len];
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) { // j要保证大于0，因为下面有取j-1作为数组下标的操作
                j = next[j - 1]; // 注意这里，是要找前一位的对应的回退位置了
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + Search_BruteForce("ababababca", "abababca"));
        System.out.println("2 ?= " + ViolentMatch("ababababca", "abababca"));

        System.out.println("2 ?= " + KMP("ababababca", "abababca"));

        System.out.println("[] ?= " + Arrays.toString(buildNextArray("abcabf")));
        System.out.println("[] ?= " + Arrays.toString(getNext("abcabf")));
        System.out.println("[] ?= " + Arrays.toString(getNext_carl("abcabf")));
    }
}
