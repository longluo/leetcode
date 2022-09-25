package com.longluo.leetcode.dp;

/**
 * 788. 旋转数字
 * <p>
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * 示例：
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * 提示：
 * N 的取值范围是 [1, 10000]。
 * <p>
 * https://leetcode.cn/problems/rotated-digits/
 */
public class Problem788_rotatedDigits {

    // BF time: O(n) space: O(C)
    public static int rotatedDigits_bf(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';

                if (digit == 3 || digit == 4 || digit == 7) {
                    flag = false;
                    break;
                } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    flag = true;
                }
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + rotatedDigits_bf(10));
        System.out.println("12 ?= " + rotatedDigits_bf(25));
        System.out.println("13 ?= " + rotatedDigits_bf(26));
    }
}
