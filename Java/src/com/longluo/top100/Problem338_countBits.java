package com.longluo.top100;

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

    // BF time: O(nlogn) space: O(1)
    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp > 0) {
                count += temp & 1;
                temp = temp >> 1;
            }

            ans[i] = count;
        }

        return ans;
    }

    // API time: O(n) space: O(1)
    public static int[] countBits_api(int num) {
        int[] ans = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

    // Odd Even time: O(n) space: O(n)
    public static int[] countBits_oddeven(int num) {
        if (num < 1) {
            return new int[]{0};
        }
        int[] res = new int[num + 1];
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }

        return res;
    }

    // DP
    public static int[] countBits_oddeven_opt(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println("[0] ?= " + Arrays.toString(countBits(0)));
        System.out.println("[0,1] ?= " + Arrays.toString(countBits(1)));
        System.out.println("[0,1,1] ?= " + Arrays.toString(countBits(2)));
        System.out.println("[0,1,1,2,1,2] ?= " + Arrays.toString(countBits(5)));

        System.out.println("[0,1,1,2,1,2] ?= " + Arrays.toString(countBits_api(5)));
        System.out.println("[0,1,1,2,1,2] ?= " + Arrays.toString(countBits_oddeven(5)));
        System.out.println("[0,1,1,2,1,2,2,3,1] ?= " + Arrays.toString(countBits_oddeven(8)));
        System.out.println("[0,1,1,2,1,2,2,3,1] ?= " + Arrays.toString(countBits_oddeven_opt(8)));
    }
}
