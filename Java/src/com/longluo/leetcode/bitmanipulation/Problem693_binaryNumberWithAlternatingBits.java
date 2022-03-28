package com.longluo.leetcode.bitmanipulation;

/**
 * 693. 交替位二进制数
 * <p>
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * 示例 1：
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 示例 3：
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 */
public class Problem693_binaryNumberWithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if ((i % 2 == 0 && str.charAt(i) == '0') || (i % 2 == 1 && str.charAt(i) == '1')) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasAlternatingBits_str(int n) {
        String str = Integer.toBinaryString(n);
        if (str.contains("00") || str.contains("11")) {
            return false;
        }

        return true;
    }

    public static boolean hasAlternatingBits_table(int n) {
        int[] nums = {1, 2, 5, 10, 21, 42, 85, 170, 341, 682, 1365, 2730, 5461, 10922,
                21845, 43690, 87381, 174762, 349525, 699050, 1398101, 2796202, 5592405,
                11184810, 22369621, 44739242, 89478485, 178956970, 357913941, 715827882,
                1431655765};
        for (int i = 0; i < nums.length; i++) {
            if (n == nums[i]) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasAlternatingBits_bit(int n) {
        n = n ^ (n >> 1);
        return (n & (long) (n + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(1));
        System.out.println(hasAlternatingBits(4));
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
    }
}
