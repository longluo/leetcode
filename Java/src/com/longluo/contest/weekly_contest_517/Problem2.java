package com.longluo.contest.weekly_contest_517;

/**
 * 4039. 解码值之和
 * <p>
 * 中等
 * <p>
 * 给你一个整数数组 nums。
 * <p>
 * 每个 nums[i] 都是一个 编码后的 整数，表示两个正整数 xi 和 yi。要解码 nums[i]，定义：
 * <p>
 * widthi = nums[i] % 10。
 * di = floor(nums[i] / 10)。
 * xi 为由 di 的十进制表示中前 widthi 位数字组成的整数。
 * yi 为由 di 的十进制表示中剩余所有数字组成的整数。
 * 保证 di 的十进制表示包含的数字位数大于 widthi。因此，xi 和 yi 都至少包含一位数字。
 * nums[i] 的 解码值 为 xiyi。
 * <p>
 * 返回 nums 中所有元素的解码值之和，并对 10^9 + 7 取模。
 * <p>
 * floor() 函数返回除法结果的整数部分。
 * <p>
 * 示例 1：
 * 输入： nums = [231]
 * 输出： 8
 * 解释：
 * 对于 231，有 width = 1、d = 23、x = 2、y = 3。
 * 231 的解码值为 2^3 = 8。
 * 由于 nums 中只有一个元素，因此所有解码值之和为 8。
 * <p>
 * 示例 2：
 * 输入： nums = [2522,2101]
 * 输出： 1649
 * 解释：
 * 对于 2522，有 width = 2、d = 252、x = 25、y = 2。
 * 2522 的解码值为 252 = 625。
 * 对于 2101，有 width = 1、d = 210、x = 2、y = 10。
 * 2101 的解码值为 2^10 = 1024。
 * 所有解码值之和为 625 + 1024 = 1649。
 * <p>
 * 示例 3：
 * 输入： nums = [2301]
 * 输出： 73741817
 * 解释：
 * 对于 2301，有 width = 1、d = 230、x = 2、y = 30。
 * 其解码值为 2^30 = 1073741824。
 * 因此，答案为 1073741824 modulo (10^9 + 7) = 73741817。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 100 < nums[i] < 10^15
 * 1 <= widthi <= 9
 * 1 <= xi, yi < 10^9
 * 用于构成 xi 和 yi 的数字序列均不包含前导零。
 * 保证 nums 中的每个元素都是有效的编码整数。
 * <p>
 * https://leetcode.cn/problems/sum-of-decoded-numbers/description/
 */
public class Problem2 {

    public static int sumDecoded(long[] nums) {
        int mod = 1_000_000_007;

        long ans = 0;

        for (long item : nums) {
            String num = Long.toString(item);
            int len = num.length();
            int w = num.charAt(len - 1) - '0';
            long x = Long.parseLong(num.substring(0, w));
            long y = Long.parseLong(num.substring(w, len - 1));

            ans += quickMul(x, y, mod);
            ans = ans % mod;
        }

        return (int) ans;
    }

    public static long quickMul(long x, long N, long mod) {
        long ans = 1;
        long x_mul = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans = ans * x_mul;
                ans = ans % mod;
            }

            x_mul = x_mul * x_mul;
            x_mul = x_mul % mod;
            N /= 2;
        }

        return ans % mod;
    }

    public static void main(String[] args) {
        System.out.println("87497779 ?= " + sumDecoded(new long[]{55162, 86552}));
        System.out.println("351394827 ?= " + sumDecoded(new long[]{55792}));
        System.out.println("44723187 ?= " + sumDecoded(new long[]{59412}));
        System.out.println("8 ?= " + sumDecoded(new long[]{231}));
        System.out.println("73741817 ?= " + sumDecoded(new long[]{2301}));
        System.out.println("1649 ?= " + sumDecoded(new long[]{2522, 2101}));
    }
}
