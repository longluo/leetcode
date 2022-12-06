package com.longluo.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. 字符串中不同整数的数目
 * <p>
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * <p>
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。
 * 注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * <p>
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * <p>
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * 示例 1：
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * <p>
 * 示例 2：
 * 输入：word = "leet1234code234"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * 提示：
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 */
public class Problem1805_numberOfDifferentIntegersInAString {

    // Simulate time: O(n) space: O(n)
    public static int numDifferentIntegers(String word) {
        int len = word.length();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();

            while (i < len && Character.isDigit(word.charAt(i))) {
                sb.append(word.charAt(i));
                i++;
            }

            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            if (sb.length() > 0) {
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + numDifferentIntegers("a"));
        System.out.println("1 ?= " + numDifferentIntegers("123"));
        System.out.println("1 ?= " + numDifferentIntegers("0"));
        System.out.println("1 ?= " + numDifferentIntegers("a0"));
        System.out.println("1 ?= " + numDifferentIntegers("a0b0"));
        System.out.println("1 ?= " + numDifferentIntegers("a1b01c001"));
        System.out.println("2 ?= " + numDifferentIntegers("leet1234code234"));
        System.out.println("3 ?= " + numDifferentIntegers("a123bc34d8ef34"));
    }
}
