package com.longluo.leetcode.dp;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * https://leetcode-cn.com/problems/counting-bits
 */
public class Problem338_countBits {

    public static int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }

        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int j = i;
            while (j > 0) {
                count += j & 1;
                j = j >> 1;
            }

            res[i] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[0] ?= " + Arrays.toString(countBits(0)));
        System.out.println("[0,1] ?= " + Arrays.toString(countBits(1)));
        System.out.println("[0,1,1] ?= " + Arrays.toString(countBits(2)));
        System.out.println("[0,1,1,2,1,2] ?= " + Arrays.toString(countBits(5)));
    }
}
