package com.longluo.leetcode.math;

/**
 * 1281. 整数的各位积和之差
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * 示例 1：
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * 示例 2：
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class Problem1281_subtractProductAndSum {

    public static int subtractProductAndSum_str(int n) {
        if (n <= 1) {
            return 0;
        }

        String str = String.valueOf(n);
        int sum = 0;
        int product = 1;
        for (char ch : str.toCharArray()) {
            int num = ch - '0';
            product *= num;
            sum += num;
        }

        return product - sum;
    }

    public static int subtractProductAndSum_math(int n) {
        if (n <= 1) {
            return 0;
        }

        int sum = 0;
        int product = 1;
        while (n != 0) {
            int num = n % 10;
            product *= num;
            sum += num;
            n /= 10;
        }

        return product - sum;
    }

    public static void main(String[] args) {

    }
}
