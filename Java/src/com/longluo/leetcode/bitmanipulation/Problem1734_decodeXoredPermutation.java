package com.longluo.leetcode.bitmanipulation;

import java.util.Arrays;

/**
 * 1734. 解码异或后的排列
 * <p>
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>
 * 示例 1：
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * <p>
 * 示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 * <p>
 * 提示：
 * 3 <= n < 10^5
 * n 是奇数。
 * encoded.length == n - 1
 * <p>
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 */
public class Problem1734_decodeXoredPermutation {

    public static int[] decode(int[] encoded) {
        if (encoded == null || encoded.length < 2) {
            return new int[]{};
        }

        int n = encoded.length + 1;
        int[] perm = new int[n];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }

        int odd = 0;
        for (int i = 0; 2 * i + 1 < n - 1; i++) {
            odd ^= encoded[2 * i + 1];
        }

        perm[0] = sum ^ odd;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }

        return perm;
    }

    public static void main(String[] args) {
        System.out.println("[1,2,3] ?= " + Arrays.toString(decode(new int[]{3, 1})));
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 3);
        System.out.println("[2,4,1,5,3] ?= " + Arrays.toString(decode(new int[]{6, 5, 4, 6})));
        System.out.println(1 ^ 5 ^ 6);
    }
}
