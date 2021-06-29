package com.longluo.leetcode.math;

/**
 * 168. Excel表列名称
 * <p>
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class Problem168_excelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                sb.append('Z');
            } else {
                sb.append((char)('A' + mod - 1));
            }
            columnNumber = (columnNumber - 1) / 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("A ?= " + convertToTitle(1));
        System.out.println("B ?= " + convertToTitle(2));
        System.out.println("Z ?= " + convertToTitle(26));
        System.out.println("AA ?= " + convertToTitle(27));
        System.out.println("AB ?= " + convertToTitle(28));
        System.out.println("AC ?= " + convertToTitle(29));
    }
}
