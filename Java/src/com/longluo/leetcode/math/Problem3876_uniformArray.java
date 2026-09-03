package com.longluo.leetcode.math;

/**
 * 3876. 构造奇偶一致的数组 II
 * <p>
 * https://leetcode.cn/problems/construct-uniform-parity-array-ii/description/
 */
public class Problem3876_uniformArray {

    public static boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean hasOddNum = false;

        for (int x : nums1) {
            min = Math.min(x, min);
            if ((x & 1) == 1) {
                hasOddNum = true;
            }
        }

        if ((min & 1) == 1) {
            return true;
        }

        return !hasOddNum;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + uniformArray(new int[]{1, 4, 7}));
        System.out.println("false ?= " + uniformArray(new int[]{2, 3}));
        System.out.println("true ?= " + uniformArray(new int[]{4, 6}));
    }
}
