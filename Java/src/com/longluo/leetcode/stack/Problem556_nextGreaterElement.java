package com.longluo.leetcode.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 556. 下一个更大元素 III
 * <p>
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
 * 如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：21
 * <p>
 * 示例 2：
 * 输入：n = 21
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 *
 */
public class Problem556_nextGreaterElement {

    public static int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }

        List<Integer> nums = new LinkedList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        int ans = 1;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("213 ?= " + nextGreaterElement(132));
        System.out.println("21 ?= " + nextGreaterElement(12));
        System.out.println("-1 ?= " + nextGreaterElement(1));
        System.out.println("-1 ?= " + nextGreaterElement(10));
        System.out.println("-1 ?= " + nextGreaterElement(55));
        System.out.println("-1 ?= " + nextGreaterElement(21));
        System.out.println("-1 ?= " + nextGreaterElement(123));
    }
}
