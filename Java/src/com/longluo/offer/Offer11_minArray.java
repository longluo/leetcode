package com.longluo.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11_minArray {

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers[0];
        }

        int idx = -1;
        int max = -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (max <= numbers[i]) {
                max = numbers[i];
                idx = i;
            }

            if (numbers[i] > numbers[i + 1]) {
                return numbers[idx + 1];
            }
        }

        return numbers[0];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println("0 ?= " + minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
