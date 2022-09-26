package com.longluo.lcci;

import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * <p>
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 * <p>
 * 示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 * <p>
 * 提示：
 * nums.length <= 30000
 * <p>
 * https://leetcode.cn/problems/missing-two-lcci/
 */
public class Lcci_17_19_missingTwo {

    // Sort time: O(nlogn) space: O(logn)
    public static int[] missingTwo(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        int[] ans = new int[2];
        int p = 0;
        int q = 0;
        for (int i = 1; i <= len + 2; i++) {
            if (p < len && nums[p] == i) {
                p++;
                continue;
            }

            ans[q] = i;
            q++;
            if (q == 2) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] ?= " + Arrays.toString(missingTwo(new int[]{1})));
        System.out.println("[1, 4] ?= " + Arrays.toString(missingTwo(new int[]{2, 3})));
    }
}
