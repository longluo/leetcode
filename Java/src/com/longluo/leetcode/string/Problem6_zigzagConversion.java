package com.longluo.leetcode.string;

/**
 * 6. Z 字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Problem6_zigzagConversion {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder(len);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("A ?= " + convert("A", 1));
        System.out.println("PAHNAPLSIIGYIR ?= " + convert("PAYPALISHIRING", 3));
        System.out.println("PINALSIGYAHRPI ?= " + convert("PAYPALISHIRING", 4));
    }
}
