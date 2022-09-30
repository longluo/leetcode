package com.longluo.lcci;

/**
 * 面试题 01.03. URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例 1：
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * <p>
 * 示例 2：
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>
 * 提示：
 * 字符串长度在 [0, 500000] 范围内。
 * <p>
 * https://leetcode.cn/problems/string-to-url-lcci/
 */
public class Lcci_01_03_stringToUrl {

    // Regex time: O(n) space: O(n)
    public static String replaceSpaces_regex(String s, int length) {
        return s.substring(0, length).replaceAll(" ", "%20");
    }

    // Simulate time: O(n) space: O(n)
    public static String replaceSpaces(String s, int length) {
        int len = s.length();

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Array time: O(n) space: O(n)
    public static String replaceSpaces_array(String s, int length) {
        char[] array = s.toCharArray();

        int len = s.length();
        int idx = len - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                array[idx--] = '0';
                array[idx--] = '2';
                array[idx--] = '%';
            } else {
                array[idx] = array[i];
                idx--;
            }
        }

        return new String(array, idx + 1, len - idx - 1);
    }

    public static void main(String[] args) {
        System.out.println("Mr%20John%20Smith ?= " + replaceSpaces_regex("Mr John Smith    ", 13));
        System.out.println("Mr%20John%20Smith ?= " + replaceSpaces("Mr John Smith    ", 13));
        System.out.println("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf ?= " + replaceSpaces_array("ds sdfs afs sdfa dfssf asdf             ", 27));
    }
}
