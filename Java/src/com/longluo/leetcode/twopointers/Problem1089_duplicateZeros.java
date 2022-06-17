package com.longluo.leetcode.twopointers;

import java.util.Arrays;

/**
 * 1089. 复写零
 * <p>
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * 提示：
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * https://leetcode.cn/problems/duplicate-zeros/
 */
public class Problem1089_duplicateZeros {

    // BF time: O(n) space: O(n)
    public static void duplicateZeros_bf(int[] arr) {
        int len = arr.length;
        int[] back = new int[len];
        for (int i = 0, j = 0; i < len && j < len; i++) {
            if (arr[i] != 0) {
                back[j++] = arr[i];
            } else {
                back[j++] = 0;
                if (j < len) {
                    back[j++] = 0;
                }
            }
        }

        System.arraycopy(back, 0, arr, 0, len);
    }

    public static void main(String[] args) {
        int[] tst1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros_bf(tst1);
        System.out.println(Arrays.toString(tst1));
    }
}
