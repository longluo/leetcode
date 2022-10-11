package com.longluo.algo200;

/**
 * 246. 中心对称数
 * <p>
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * <p>
 * 示例 1:
 * 输入: num = "69"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: num = "88"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: num = "962"
 * 输出: false
 * <p>
 * 示例 4：
 * 输入：num = "1"
 * 输出：true
 * <p>
 * https://leetcode.cn/problems/strobogrammatic-number/
 */
public class Problem246_strobogrammaticNumber {

    // Simulate time: O(n) space: O(n)
    public static boolean isStrobogrammatic(String num) {
        int len = num.length();

        StringBuilder ans = new StringBuilder(len);
        for (int i = len - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if (ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '7') {
                return false;
            }

            if (ch == '6') {
                ch = '9';
            } else if (ch == '9') {
                ch = '6';
            }

            ans.append(ch);
        }

        for (int i = 0; i < len; i++) {
            if (num.charAt(i) != ans.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isStrobogrammatic("69"));
        System.out.println("true ?= " + isStrobogrammatic("88"));
        System.out.println("false ?= " + isStrobogrammatic("962"));
    }
}
