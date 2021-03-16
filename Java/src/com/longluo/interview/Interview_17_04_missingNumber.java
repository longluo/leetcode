package com.longluo.interview;

import java.util.Arrays;

/**
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 */
public class Interview_17_04_missingNumber {

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            } else {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + missingNumber(new int[]{3, 0, 1}));
        System.out.println("8 ?= " + missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println("1 ?= " + missingNumber(new int[]{0}));
    }
}
