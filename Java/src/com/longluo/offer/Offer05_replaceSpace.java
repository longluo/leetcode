package com.longluo.offer;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * 0 <= s的长度 <= 10000
 * <p>
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class Offer05_replaceSpace {

    public static String replaceSpace(String s) {
        return s.replaceAll("\\ ", "%20");
    }

    public static String replaceSpace_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }

    public static String replaceSpace_2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        char[] array = new char[n * 3];
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                array[size++] = s.charAt(i);
            } else {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }
        }

        return new String(array, 0, size);
    }

    public static void main(String[] args) {
        System.out.println("We%20are%20happy. ?= " + replaceSpace("We are happy."));
        System.out.println("We%20are%20happy. ?= " + replaceSpace_1("We are happy."));
        System.out.println("We%20are%20happy. ?= " + replaceSpace_2("We are happy."));
    }
}
