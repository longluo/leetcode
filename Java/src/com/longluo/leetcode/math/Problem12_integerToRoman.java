package com.longluo.leetcode.math;

/**
 * 12. 整数转罗马数字
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 提示：
 * 1 <= num <= 3999
 * <p>
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Problem12_integerToRoman {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while (num >= 1000) {
            sb.append(getStr(num / 1000, "M"));
            num %= 1000;
        }

        sb.append(process(num));

        return sb.toString();
    }

    public static String process(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 900) {
            sb.append("CM");
            num -= 900;
        }

        while (num >= 500 && num < 900) {
            sb.append("D");
            num -= 500;
        }

        while (num >= 400 && num < 500) {
            sb.append("CD");
            num -= 400;
        }

        while (num >= 100 && num < 400) {
            sb.append(getStr(num / 100, "C"));
            num %= 100;
        }

        while (num >= 90) {
            sb.append("XC");
            num -= 90;
        }

        while (num >= 50 && num < 90) {
            sb.append("L");
            num -= 50;
        }

        while (num >= 40 && num < 50) {
            sb.append("XL");
            num -= 40;
        }

        while (num >= 10 && num < 40) {
            sb.append(getStr(num / 10, "X"));
            num %= 10;
        }

        while (num >= 9) {
            sb.append("IX");
            num -= 9;
        }

        while (num >= 5 && num < 9) {
            sb.append("V");
            num -= 5;
        }

        while (num >= 4 && num < 5) {
            sb.append("IV");
            num -= 4;
        }

        while (num >= 1 && num < 4) {
            sb.append(getStr(num / 1, "I"));
            num %= 1;
        }

        return sb.toString();
    }

    public static String getStr(int repeatNum, String symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatNum; i++) {
            sb.append(symbol);
        }

        return sb.toString();
    }

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman_2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    static String[] thousands = {"", "M", "MM", "MMM"};
    static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman_3(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println("III ?= " + intToRoman(3));
        System.out.println("IV ?= " + intToRoman(4));
        System.out.println("IX ?= " + intToRoman(9));
        System.out.println("LVIII ?= " + intToRoman(58));
        System.out.println("MCMXCIV ?= " + intToRoman(1994));

        System.out.println("III ?= " + intToRoman_2(3));
        System.out.println("IV ?= " + intToRoman_2(4));
        System.out.println("IX ?= " + intToRoman_2(9));
        System.out.println("LVIII ?= " + intToRoman_2(58));
        System.out.println("MCMXCIV ?= " + intToRoman_2(1994));

        System.out.println("III ?= " + intToRoman_3(3));
        System.out.println("IV ?= " + intToRoman_3(4));
        System.out.println("IX ?= " + intToRoman_3(9));
        System.out.println("LVIII ?= " + intToRoman_3(58));
        System.out.println("MCMXCIV ?= " + intToRoman_3(1994));
    }
}
