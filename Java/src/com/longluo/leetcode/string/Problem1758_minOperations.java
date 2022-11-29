package com.longluo.leetcode.string;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * <p>
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * <p>
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。
 * 例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * <p>
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * <p>
 * 示例 1：
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * <p>
 * 示例 2：
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * <p>
 * 示例 3：
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s[i] 是 '0' 或 '1'
 * <p>
 * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class Problem1758_minOperations {

    // Simulate time: O(n) space: O(1)
    public static int minOperations(String s) {
        int zero = 0;
        int one = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != '0' && i % 2 == 0) {
                zero++;
            } else if (ch != '1' && i % 2 == 1) {
                zero++;
            }

            if (ch != '1' && i % 2 == 0) {
                one++;
            } else if (ch != '0' && i % 2 == 1) {
                one++;
            }
        }

        return Math.min(zero, one);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minOperations("0100"));
        System.out.println("0 ?= " + minOperations("10"));
        System.out.println("2 ?= " + minOperations("1111"));
        System.out.println("3 ?= " + minOperations("10010100"));
    }
}
