package com.longluo.leetcode.greedy;

/**
 * 738. 单调递增的数字
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * <p>
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 *
 */
public class Problem738_monotoneIncreasingDigits {

    public static int monotoneIncreasingDigits(int N) {
        char[] arr = String.valueOf(N).toCharArray();

        int max = -1;
        int idx = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }

            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for (int j = idx + 1; j < arr.length; j++) {
                    arr[j] = '9';
                }
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }

//    public static int monotoneIncreasingDigits_2(int N) {
//
//    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + monotoneIncreasingDigits(10));
        System.out.println("8 ?= " + monotoneIncreasingDigits(8));
        System.out.println("1234 ?= " + monotoneIncreasingDigits(1234));
        System.out.println("299 ?= " + monotoneIncreasingDigits(332));
        System.out.println("99 ?= " + monotoneIncreasingDigits(100));
        System.out.println("99 ?= " + monotoneIncreasingDigits(101));
        System.out.println("22999 ?= " + monotoneIncreasingDigits(23332));
    }
}
