package com.longluo.contest.weekly_contest_288;

/**
 * 2231. 按奇偶性交换后的最大数字
 * <p>
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * 返回交换 任意 次之后 num 的 最大 可能值。
 * <p>
 * 示例 1：
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * <p>
 * 示例 2：
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 * <p>
 * 提示：
 * 1 <= num <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/largest-number-after-digit-swaps-by-parity/
 */
public class Problem2231_largestNumberAfterDigitSwapsByParity {

    // String + Sort
    // TODO: 2022/6/2  
    public static int largestInteger_str(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] digitArr = new int[len];
        for (int i = 0; i < len; i++) {
            digitArr[i] = str.charAt(i) - '0';
        }

        int left = 0;
        int right = len - 1;


        int ans = 0;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3412 ?= " + largestInteger_str(1234));
        System.out.println("87655 ?= " + largestInteger_str(65875));
    }
}
