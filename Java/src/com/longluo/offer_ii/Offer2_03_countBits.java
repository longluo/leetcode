package com.longluo.offer_ii;

import java.util.Arrays;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * <p>
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * 示例 1:
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 示例 2:
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * 说明:
 * 0 <= n <= 10^5
 * <p>
 * 进阶:
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 * <p>
 * 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/
 * <p>
 * https://leetcode-cn.com/problems/w3tCBm/
 */
public class Offer2_03_countBits {

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = getOneNum(i);
        }

        return res;
    }

    public static int getOneNum(int n) {
        int ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans++;
            }

            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0] ?= " + Arrays.toString(countBits(0)));
        System.out.println("[0,1] ?= " + Arrays.toString(countBits(1)));
        System.out.println("[0,1,1] ?= " + Arrays.toString(countBits(2)));
        System.out.println("[0,1,1,2,1,2] ?= " + Arrays.toString(countBits(5)));
    }
}
