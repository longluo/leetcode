package com.longluo.algo200;

/**
 * 1056. 易混淆数
 * <p>
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 * <p>
 * 原数字旋转 180° 以后可以得到新的数字。
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 * 2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
 * 易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
 * <p>
 * 示例 1：
 * 输入：6
 * 输出：true
 * 解释：
 * 把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6 。
 * <p>
 * 示例 2：
 * 输入：89
 * 输出：true
 * 解释:
 * 把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
 * <p>
 * 示例 3：
 * 输入：11
 * 输出：false
 * 解释：
 * 把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字。
 * <p>
 * 示例 4：
 * 输入：25
 * 输出：false
 * 解释：
 * 把 25 旋转 180° 以后得到的不是数字。
 * <p>
 * 提示：
 * 0 <= N <= 10^9
 * 可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。
 * <p>
 * https://leetcode.cn/problems/confusing-number/
 */
public class Problem1056_confusingNumber {

    // Simulate time: O(logn) space: O(logn)
    public static boolean confusingNumber(int n) {
        String num = String.valueOf(n);

        int ans = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 7) {
                return false;
            }

            if (digit == 6) {
                ans = 10 * ans + 9;
            } else if (digit == 9) {
                ans = 10 * ans + 6;
            } else {
                ans = 10 * ans + digit;
            }
        }

        return n != ans;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + confusingNumber(89));
        System.out.println("false ?= " + confusingNumber(11));
        System.out.println("false ?= " + confusingNumber(25));
        System.out.println("false ?= " + confusingNumber(916));
    }
}
