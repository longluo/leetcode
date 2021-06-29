package com.longluo.leetcode.math;

/**
 * 171. Excel表列序号
 * <p>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 * <p>
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class Problem171_excelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        int base = 1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = 0;
            if (columnTitle.charAt(i) == 'Z') {
                temp = 26;
            } else {
                temp = columnTitle.charAt(i) - 'A' + 1;
            }
            ans = ans + base * temp;
            base *= 26;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + titleToNumber("A"));
        System.out.println("2 ?= " + titleToNumber("B"));
        System.out.println("3 ?= " + titleToNumber("C"));
        System.out.println("26 ?= " + titleToNumber("Z"));
        System.out.println("27 ?= " + titleToNumber("AA"));
        System.out.println("28 ?= " + titleToNumber("AB"));
        System.out.println("701 ?= " + titleToNumber("ZY"));
    }
}
