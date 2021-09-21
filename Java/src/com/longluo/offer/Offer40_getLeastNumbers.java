package com.longluo.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组arr，找出其中最小的 k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1, 2] 或者 [2, 1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Offer40_getLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }

        if (k >= arr.length) {
            return arr;
        }

        int[] ans = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1, 2] ?= " + Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println("[0] ?= " + Arrays.toString(getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
    }
}
