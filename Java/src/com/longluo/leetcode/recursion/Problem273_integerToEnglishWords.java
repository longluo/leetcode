package com.longluo.leetcode.recursion;

/**
 * 273. 整数转换英文表示
 * <p>
 * 将非负整数 num 转换为其对应的英文表示。
 * <p>
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * <p>
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * <p>
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * 示例 4：
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * 提示：
 * 0 <= num <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/integer-to-english-words/
 */
public class Problem273_integerToEnglishWords {

    private static String[] onesDigit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private static String[] teensDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};

    private static String[] tensDigit = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static String[] thousands = {"", "Thousand", "Million", "Billion"};

    private static int count = 0;

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= unit * curNum;
                sb.append(toEnglish(curNum)).append(" ").append(thousands[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    private static String toEnglish(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10) {
            sb.append(onesDigit[num]);
        } else if (num >= 10 && num < 20) {
            sb.append(teensDigit[num - 10]);
        } else if (num >= 20 && num < 100) {
            sb.append(tensDigit[num / 10]).append(" ").append(onesDigit[num % 10]);
        } else {
            sb.append(onesDigit[num / 100]).append(" Hundred ").append(toEnglish(num % 100));
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("Zero ?= " + numberToWords(0));
        System.out.println("Two ?= " + numberToWords(2));
        System.out.println("Ten ?= " + numberToWords(10));
        System.out.println("Twelve ?= " + numberToWords(12));
        System.out.println("Thirty ?= " + numberToWords(30));
        System.out.println("Sixty Seven ?= " + numberToWords(67));
        System.out.println("One Hundred ?= " + numberToWords(100));
        System.out.println("One Hundred Twenty Three ?= " + numberToWords(123));
        System.out.println("Three Hundred ?= " + numberToWords(300));
        System.out.println("One Thousand ?= " + numberToWords(1000));
        count = 0;
        System.out.println("Twelve Thousand Three Hundred Forty Five ?= " + numberToWords(12345));
        count = 0;
        System.out.println("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven ?= " + numberToWords(1234567));
        count = 0;
        System.out.println("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One ?= " + numberToWords(1234567891));
    }
}
