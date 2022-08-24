package com.longluo.leetcode.dp;

/**
 * 926. 将字符串翻转到单调递增
 * <p>
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * 示例 1：
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * <p>
 * 示例 2：
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * <p>
 * 示例 3：
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 为 '0' 或 '1'
 * <p>
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class Problem926_minFlipsMonoIncr {

    // DP
    // TODO: 2022/8/24  
    public static int minFlipsMonoIncr(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }

        int ans = 0;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minFlipsMonoIncr("00110"));
        System.out.println("2 ?= " + minFlipsMonoIncr("010110"));
        System.out.println("2 ?= " + minFlipsMonoIncr("00011000"));
    }
}
