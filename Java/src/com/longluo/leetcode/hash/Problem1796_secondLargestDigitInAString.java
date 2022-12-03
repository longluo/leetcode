package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1796. 字符串中第二大的数字
 * <p>
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * 示例 1：
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * <p>
 * 示例 2：
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 * <p>
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 */
public class Problem1796_secondLargestDigitInAString {

    // Simulate time: O(n) space: O(C)
    public static int secondHighest(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        if (map.size() <= 1) {
            return -1;
        }

        int ans = -1;
        int max = -1;
        for (Character ch : map.keySet()) {
            int digit = ch - '0';
            if (digit > max) {
                ans = max;
                max = digit;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + secondHighest("dfa12321afd"));
        System.out.println("-1 ?= " + secondHighest("abc1111"));
    }
}
