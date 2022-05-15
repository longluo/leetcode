package com.longluo.contest.biweekly_contest_78;

/**
 * 5299. 找到一个数字的 K 美丽值
 * <p>
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * <p>
 * 示例 1：
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * <p>
 * 示例 2：
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 * <p>
 * 提示：
 * 1 <= num <= 10^9
 * 1 <= k <= num.length （将 num 视为字符串）
 * <p>
 * https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
 */
public class Problem5299_findTheKBeautyOfANumber {

    // Str time: O(n) space: O(logn)
    public static int divisorSubstrings_str(int num, int k) {
        String s = String.valueOf(num);
        int len = s.length();
        int ans = 0;
        for (int i = 0; i <= len - k; i++) {
            int value = Integer.parseInt(s.substring(i, i + k));
            if (value > 0 && num % value == 0) {
                ans++;
            }
        }

        return ans;
    }

    // Count time: O(n) space: O(logn)
    public static int divisorSubstrings(int num, int k) {
        int ans = 0;

        int lowBound = (int) Math.pow(10, k - 1);
        int upperBound = (int) Math.pow(10, k);

        int temp = num;
        while (temp >= lowBound) {
            int subStrNum = temp % upperBound;
            if (subStrNum > 0 && subStrNum < upperBound && num % subStrNum == 0) {
                ans++;
            }

            temp /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(divisorSubstrings_str(240, 2));
        System.out.println(divisorSubstrings_str(430043, 2));

        System.out.println(divisorSubstrings(30003, 3));
        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
    }
}
