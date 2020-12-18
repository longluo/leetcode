package com.longluo.offer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * 0 <= s的长度 <= 10000
 */
public class Offer05_replaceSpace {

    public static String replaceSpace(String s) {
        return s.replaceAll("\\ ", "%20");
    }

    public static void main(String[] args) {
        System.out.println("We%20are%20happy. ?= " + replaceSpace("We are happy."));
    }
}
